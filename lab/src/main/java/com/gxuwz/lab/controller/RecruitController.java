package com.gxuwz.lab.controller;

import com.gxuwz.lab.api.CommonResult;
import com.gxuwz.lab.entry.Recruitment;
import com.gxuwz.lab.entry.User;
import com.gxuwz.lab.service.RecruitService;
import com.gxuwz.lab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recruit")
public class RecruitController {
	
	@Autowired
	private RecruitService recruitService;


	@GetMapping("/list")
    public CommonResult getList() {

        List<Recruitment> list = recruitService.getList();
	    if (list != null)
	        return CommonResult.success(list);
	    else
	        return CommonResult.validateFailed();

    }
	@GetMapping("/studentgetlist")
	public CommonResult stuGetList() {

		List<Recruitment> list = recruitService.stuGetList();

		if (list != null)
			return CommonResult.success(list);
		else
			return CommonResult.validateFailed();

	}



	@PostMapping("/update")
	public String update(@RequestBody Recruitment recruitment){

		System.out.println(recruitment);
		String result = recruitService.updateById(recruitment);
		if(result != null){
			return "success";
		}else{
			return "error";
		}
	}
	@PostMapping("/add")
	public String save(@RequestBody Recruitment recruitment){
//查询这个实验室部门id  通过labid和部门名称
		int id;
		if(recruitment.getSectionId()==1){
			//技术部门
			recruitment.setSectionName("技术部");
			 id=recruitService.getSectionid(recruitment);
			recruitment.setSectionId(id);
		}
		else {
			recruitment.setSectionName("后勤部");
			 id=recruitService.getSectionid(recruitment);
			recruitment.setSectionId(id);

		}
//		//更新user的sectionid
//		User user=new User();
//		user.setSectionId(id);
//		user.setUserId(recruitment.getUserId());
//		UserService.updateSecion(user);
		recruitment.setStatus(0);//审核状态0为 待审核
		System.out.println("recruitment++++:"+recruitment);
		String result = recruitService.save(recruitment);
		if(result != null){
			return "success";
		}else{
			return "error";
		}
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") Integer id){
		System.out.println(id);
		recruitService.deleteById(id);
	}


	@GetMapping("/check/{id}/{num}")
	public String check(@PathVariable("id") Integer id,@PathVariable("num") Integer num){

		String result = recruitService.check(num,id);

		if(result != null){
			return "success";
		}else{
			return "error";
		}

	}

}

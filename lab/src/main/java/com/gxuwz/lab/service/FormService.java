package com.gxuwz.lab.service;

import com.gxuwz.lab.entry.Form;
import com.gxuwz.lab.entry.Recruitment;
import com.gxuwz.lab.entry.User;
import com.gxuwz.lab.mapper.FormMapper;
import com.gxuwz.lab.mapper.RecruitMapper;
import com.gxuwz.lab.mapper.UserMapper;
import com.gxuwz.lab.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author Fonrye
 * @version 1.0
 * @creat by IntelliJ IDEA
 * @date 2021/6/14 22:43
 **/
@Transactional
@Service("formService")
public class FormService {
	@Autowired
	RecruitMapper recruitMapper;
    @Autowired
    FormMapper formMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    public String signup(Integer planId, String userId) {
        try{
            Recruitment recruitment = recruitMapper.getRecruitById(planId);

//
            String f;
            f =  formMapper.isExist(userId);
//            System.out.println("+++form ++  "+form+"  +++");

            if((f == null)){
                recruitMapper.requestNum(recruitment.getRequireNum()-1,recruitment.getId());
                formMapper.signup(planId,userId);
                return "success";

     }
            else{
                formMapper.signup2(planId,userId);
                return "success";
            }
//            else{
//
//            return "success";
//        }


        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Form> getReviewByRecruitId(Integer id) {
        return formMapper.getReviewByRecruitId(id);
    }

    public String interview( Integer sectionId, Integer planId, String userId, Integer num) {

        try{
            if(num == 2){
                userRoleMapper.toAssitant(userId,num);
                //更新user的sectionid
                User user=new User();
                user.setSectionId(sectionId);
                user.setUserId(userId);
                userMapper.updateSection(user);
            }
            formMapper.interview(planId,userId,num);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



}

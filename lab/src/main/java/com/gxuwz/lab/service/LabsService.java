package com.gxuwz.lab.service;

import com.gxuwz.lab.entry.Labs;
import com.gxuwz.lab.entry.Repair;
import com.gxuwz.lab.entry.Section;
import com.gxuwz.lab.mapper.LabsMapper;
import com.gxuwz.lab.mapper.RecruitMapper;
import com.gxuwz.lab.mapper.RepairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Fonrye
 * @version 1.0
 * @creat by IntelliJ IDEA
 * @date 2021/6/8 11:16
 **/
@Transactional
@Service("labsService")
public class LabsService {

    @Autowired
    LabsMapper labsMapper;


    public List<Labs> getList(Labs labs) {
        return labsMapper.getList(labs);
    }

    public String updateById(Labs labs) {
        try{
            labsMapper.updateById(labs);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public String save(Labs labs) {
        try{
            labsMapper.save(labs);
            Section section = new Section();
            section.setLaboratoryId(Integer.parseInt(labs.getLabId()));
            section.setSectionName("技术部");
            Section section1 = new Section();
            section1.setLaboratoryId(Integer.parseInt(labs.getLabId()));
            section1.setSectionName("后勤部");

            List<Section> list = new ArrayList<>();
            list.add(section);
            list.add(section1);
            labsMapper.saveSection(list);
            System.out.println("进入到保存实验室方法");
            return "success";
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public void deleteById(int id) {
        labsMapper.deleteLabsById(id);
        labsMapper.deleteLabsById2(id);
    }
}

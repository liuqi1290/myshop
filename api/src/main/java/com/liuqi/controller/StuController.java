package com.liuqi.controller;

import com.liuqi.pojo.Stu;
import com.liuqi.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class StuController {
    @Autowired
    private StuService stuServicel;
    @GetMapping("/getStu")
    public Object querya(String  id){
        Stu stu = stuServicel.query(Integer.parseInt(id));
        return stu;
    }

    @PostMapping("/addStu")
    public Object addStu(){

        Stu stu = null;
        int add = stuServicel.add(stu);
        return add;
    }

    @PostMapping("/editStu")
    public Object editStu(){

        Stu stu = null;
        int i = stuServicel.edit(stu);
        return i ;
    }

    @PostMapping("/delStu")
    public Object delStu(String id){
        int i = stuServicel.del(Integer.parseInt(id));
        return i ;
    }
}

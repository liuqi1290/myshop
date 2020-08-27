package com.liuqi.service.Impl;


import com.liuqi.mapper.StuMapper;
import com.liuqi.pojo.Stu;
import com.liuqi.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper mapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu query(int id) {
        Stu stu = mapper.selectByPrimaryKey(id);
        return stu;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int del(int id) {
        int i = mapper.deleteByPrimaryKey(id);
        return i;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int edit(Stu stu) {
        stu.setId(1002);
        stu.setAge(20);
        return mapper.updateByPrimaryKey(stu);
    }

    @Override
    public int addparent(Stu stu) {
        stu.setId(444);
        stu.setAge(20);
        stu.setName("parent");
        return mapper.insert(stu);
    }

    //@Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int addchild(Stu stu) {
        addchild1(stu);
        int a= 1/0;
        addchild1(stu);
        return 0;
    }

    public int addchild1(Stu stu) {
        stu.setId(111);
        stu.setAge(20);
        stu.setName("child-1");
        return mapper.insert(stu);
    }

    public int addchild2(Stu stu) {
        stu.setId(111);
        stu.setAge(20);
        stu.setName("child-2");
        return mapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int add(Stu stu) {
        stu.setId(11661);
        stu.setAge(20);
        stu.setName("add");
        return mapper.insert(stu);
    }
}

package com.liuqi.testService.Impl;
import com.liuqi.pojo.Stu;
import com.liuqi.service.StuService;
import com.liuqi.testService.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService{
    @Autowired
    private StuService stuServicel;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testTransService(){
        Stu stu = new Stu();
        stuServicel.addparent(stu);
        stuServicel.addchild(stu);
    }
}

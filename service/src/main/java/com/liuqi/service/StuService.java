package com.liuqi.service;

import com.liuqi.pojo.Stu;


public interface StuService {
    public Stu query (int id);
    public int del (int id);
    public int edit (Stu stu);
    public int add (Stu stu);
    public int addparent (Stu stu);
    public int addchild (Stu stu);

}

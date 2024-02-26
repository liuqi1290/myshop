package com.liuqi.suanfa.shuzu;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test
{
    public static Test t1 = new Test();
    {
         System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        Test t2 = new Test();
         String a[]=new String[50];
         String[] d=new String[50];
    }
 }
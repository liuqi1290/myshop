package com.liuqi.design.principle.decorator;

public class ConcreteComponent implements Component{
    /**
     * @desc 基本操作
     * @author LiuQi
     * @date 2019/12/24
     * @params
     * @return
     */
    @Override
    public void performOperation() {
        System.out.println("画了一片树叶");
    }
}

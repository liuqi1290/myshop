package com.liuqi.design.principle.proxyModel.JDKProxy;

;

/**
 * 目标类
 *
 * @auther liuqi
 * @create 2021-01-14  15:49
 */


public class TargetIteacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("目标对象执行方法！");
    }
}

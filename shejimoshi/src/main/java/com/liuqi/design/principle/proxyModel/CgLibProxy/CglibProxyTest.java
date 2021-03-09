package com.liuqi.design.principle.proxyModel.CgLibProxy;

;

/**
 *  Cglib动态代理    是通过动态创建目标类的子类实现代理
 * @auther liuqi
 * @create 2021-01-14  16:36
 */


public class CglibProxyTest {
    public static void main(String[] args) {
        TargetTeacher targetTeacher=new TargetTeacher();
        CglibProxyFactory cglibProxyFactory=new CglibProxyFactory(targetTeacher);
        TargetTeacher proxyInstance=(TargetTeacher) cglibProxyFactory.getProxyInstance();
        proxyInstance.teach();
    }
}

package com.liuqi.design.principle.proxyModel.JDKProxy;

;

/**
 * @auther liuqi
 * @create 2021-01-14  16:01
 */


public class ProxyTest {
    public static void main(String[] args) {
        TargetIteacher targetIteacher=new TargetIteacher();
        ProxyFactory proxyFactory=new ProxyFactory(targetIteacher);
        ITeacher instance=(ITeacher) proxyFactory.getProxyInstance();
        System.out.println("动态代理类对象："+instance.getClass());

        instance.teach();
        //执行的结果：
        /*动态代理类对象：class com.sun.proxy.$Proxy0
        JDk动态代理开始
        目标对象执行方法！
        动态代理提交*/
    }
}

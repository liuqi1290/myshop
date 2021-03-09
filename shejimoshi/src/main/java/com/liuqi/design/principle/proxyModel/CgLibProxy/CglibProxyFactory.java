package com.liuqi.design.principle.proxyModel.CgLibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

;import java.lang.reflect.Method;

/**
 * @auther liuqi
 * @create 2021-01-14  16:29
 */


public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target=target;
    }

    public Object getProxyInstance(){
        //Cglib 提供的工具
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //设置回调韩式
        enhancer.setCallback(this);
        //创建代理子类
       return enhancer.create();
    }

    //重写该方法 执行目标方法  ，该方法即是对目标方法的增强
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理模式开始=-=");
        Object invoke=method.invoke(o, objects);
        System.out.println("Cglib代理模式结束=-=");
        return invoke;
    }
}

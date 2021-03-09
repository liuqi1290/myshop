package com.liuqi.design.principle.proxyModel.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

;

/**
 * 代理工厂
 *
 * @auther liuqi
 * @create 2021-01-14  15:52
 */


public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target=target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDk动态代理开始");
                        ITeacher invoke=(ITeacher) method.invoke(target, args);
                        System.out.println("动态代理提交");
                        return invoke;
                    }
                });
    }


}

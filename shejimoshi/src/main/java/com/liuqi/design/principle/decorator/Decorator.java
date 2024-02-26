package com.liuqi.design.principle.decorator;

/**
 * @author LiuQi
 * @date 2019/10/13
 * @description
 * 装饰者
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void performOperation() {
        component.performOperation();
    }
}

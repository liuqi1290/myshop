package com.liuqi.design.principle.decorator;

/**
 *
 *  @author : liuqi
 *  @version : 1.0.0
 *  @Date : 2017年11月12日
 *  @Desc : 具体装饰角色B
 */
public class ConcreteDecoratorB extends Decorator{

	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
    public void performOperation() {
        //调用原有业务方法
        super.performOperation();
        this.deconrtorBOperation();

    }
    private  void deconrtorBOperation() {
        System.out.println("给图上颜色的树叶的画装上相框");
    }
}

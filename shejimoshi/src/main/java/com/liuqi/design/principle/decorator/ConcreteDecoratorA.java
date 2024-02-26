package com.liuqi.design.principle.decorator;

/**
 * @author : liuqi
 * @version : v1.0
 * @description : 具体装饰角色A
 * @date : 2020-01-03 17:01
 */
public class ConcreteDecoratorA  extends Decorator{

	public ConcreteDecoratorA(Component component) {
		      super(component);
	}
	@Override
    public void performOperation() {
        //调用原有业务方法
        super.performOperation();
        this.deconrtorAOperation();

    }
    private  void deconrtorAOperation() {
        System.out.println("给树叶涂上颜色");
    }
}

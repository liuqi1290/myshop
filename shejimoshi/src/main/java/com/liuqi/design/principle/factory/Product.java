package com.liuqi.design.principle.factory;

/**
 * @program : DesignPatterns
 * @author : liuqi
 * @version : v1.0
 * @description : 产品接口
 * @date : 2020/1/19 15:28
 * Modification History:
 * Date         Author          Version            Description
 * ------------------------------------------------------------
 *
 */
//首先，定义一个产品基类，这个基类包含一个工厂方法，用于创建该基类的具体产品类。
public abstract class Product {
 public abstract void use();
}

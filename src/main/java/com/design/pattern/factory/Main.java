package com.design.pattern.factory;


import com.design.pattern.factory.methodFactory.AbstractMethodFatory;
import com.design.pattern.factory.methodFactory.impl.FactoryA;
import com.design.pattern.factory.simpleFactory.SimpleFactory;


public class Main
{
    public static void main(String[] args)
    {
        // simple();
        System.out.println("----------------------");
        methodFactory();
    }

    /**
     * 简单工厂测试
     */
    public static void simple()
    {
        SimpleFactory.executeAction("A");
    }

    public static void methodFactory()
    {
        // 此处还是包含一定的业务判断逻辑
        // 依据选择的条件实例化抽象工厂角色
        AbstractMethodFatory factory = new FactoryA();
        Product product = factory.action();
        product.action();
    }
}

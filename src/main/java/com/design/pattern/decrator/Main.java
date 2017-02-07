package com.design.pattern.decrator;

public class Main
{
    public static void main(String[] args)
    {
        decoratorTest();
    }

    public static void decoratorTest()
    {
        // 定义起始的行为对象，即可以是具体构件角色
        Component component = new ConcreteComponent();
        // 装饰对象
        Decorator decorator1 = new ConcreteDecorator();
        // 装饰对象
        Decorator decorator2 = new ConcreteDecoratorOther();
        // 构造装饰链
        decorator2.setComponent(decorator1);
        decorator1.setComponent(component);
        // 开始执行行为
        decorator2.operation();
    }
}

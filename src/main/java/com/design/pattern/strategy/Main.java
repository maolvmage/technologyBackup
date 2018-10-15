package com.design.pattern.strategy;

public class Main
{
    public static void main(String[] args)
    {
        stargetyTest();
    }

    public static void stargetyTest()
    {
        // 此处还是包含了一部分的业务判断逻辑
        AbstractStrategy stragety = new ConcreteStragety();
        StragetyContext context = new StragetyContext();
        // 赋予决策环境对象真正的具体的决策对象
        context.setStragety(stragety);
        context.action();
    }
}

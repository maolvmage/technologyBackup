package com.design.pattern.adapter;

/**
 * <h1>源角色</h1>
 * <p>
 * 此类/接口是在适配器模式中需要适配的对象
 * </p>
 */

public class Adaptee
{
    public void action()
    {
        System.out.println("当前类为" + this.getClass().getSimpleName()
                + " 执行的为源角色中的方法");
    }

    public void action2()
    {
        System.out.println("当前类为" + this.getClass().getSimpleName()
                + " 执行的为源角色中的方法");
    }

}

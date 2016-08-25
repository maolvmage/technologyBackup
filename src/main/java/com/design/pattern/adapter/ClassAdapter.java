package com.design.pattern.adapter;

/**
 * <h1>具体的类适配者角色</h1> <p> 如果作为类适配模式的话，需要同时继承源角色，并且实现目标角色.缺点是不能在源角色上进行方法的添加 </p>
 */

public class ClassAdapter extends Adaptee implements Target
{

    public void operate()
    {
        System.out.println("当前类为" + this.getClass().getSimpleName() + "执行的为类适配角色的自定义方法");
    }

    /**
     * 覆盖源角色中的方法
     */
    @Override
    public void action2()
    {
        System.out.println("当前类为" + this.getClass().getSimpleName() + " 执行的为覆盖源角色的自定义方法");
    }
}

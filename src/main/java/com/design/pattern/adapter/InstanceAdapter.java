package com.design.pattern.adapter;

/**
 * <h1>对象适配模式</h1> <p> 在该类中定义一个源角色，可以在源角色方法上添加新的逻辑，缺点是不能对源角色的方法进行覆盖 </p>
 */

public class InstanceAdapter implements Target
{
    /**
     * 对象适配模式使用组合的方式进行包含源角色
     */
    private Adaptee adaptee;

    public InstanceAdapter(Adaptee _adaptee)
    {
        setAdaptee(_adaptee);
    }

    public void operate()
    {

    }

    public void action()
    {
        add();
        getAdaptee().action();
    }

    private void add()
    {
        System.out.println("执行源角色方法前添加逻辑 ");
    }

    public Adaptee getAdaptee()
    {
        return adaptee;
    }

    public void setAdaptee(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }
}

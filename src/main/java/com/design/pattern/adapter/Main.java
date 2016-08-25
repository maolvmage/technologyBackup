package com.design.pattern.adapter;

public class Main
{
    public static void main(String[] args)
    {
        // 调用类适配器模式
        // 此处生命适配角色时，不可以使用目标适配角色，因为它是一个接口，其中没有源角色中定义的方法
        ClassAdapter classApater = new ClassAdapter();
        classApater.action();
        // 执行覆盖了源角色中的方法
        classApater.action2();
        // 调用对象适配器模式
        Adaptee adaptee = new Adaptee();
        Target instanceAdapter = new InstanceAdapter(adaptee);
        instanceAdapter.action();
    }
}

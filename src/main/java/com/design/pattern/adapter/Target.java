package com.design.pattern.adapter;

/**
 * <h1>目标对象角色</h1>
 * <p>
 * 该类必须为接口(因为JAVA不支持多继承，除非使用内部类的方式实现，用处较少)
 * </p>
 * <p>
 * 该类就是客户端象牙使用的接口/类
 * </p>
 */

public interface Target
{
    /**
     * 类适配模式中自定义的方法
     */
    void operate();

    /**
     * 源对象中固有的方法
     */
    void action();

}

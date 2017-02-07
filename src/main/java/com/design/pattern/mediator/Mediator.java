package com.design.pattern.mediator;

/**
 * <h1>抽象调停者(Mediator)角色</h1>
 * <p>
 * 定义出同事对象到调停者对象的接口，其中主要方法是一个（或多个）事件方法。
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月19日 下午8:55:59
 */
public abstract class Mediator
{
    /**
     * 改变被调停者的行为
     * 
     * @param colleague
     *            持有该调停者的对象
     */
    public abstract void change(Colleague colleague);
}

package com.design.pattern.mediator;

/**
 * <h1>抽象同事类(Colleague)角色</h1>
 * <p>
 * 定义出调停者到同事对象的接口。同事对象只知道调停者而不知道其余的同事对象
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月19日 下午8:57:21
 */
public abstract class Colleague
{
    /**
     * 构造函数
     * 
     * @param _mediator
     *            调停者
     */
    public Colleague(Mediator _mediator)
    {
        setMediator(_mediator);
    }

    /**
     * 执行行为
     */
    public abstract void action();

    /**
     * 持有一个调停者
     */
    private Mediator mediator;

    public Mediator getMediator()
    {
        return mediator;
    }

    public void setMediator(Mediator mediator)
    {
        this.mediator = mediator;
    }

}

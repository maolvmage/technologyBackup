package com.design.pattern.Command;

/**
 * <h1>请求发起者角色</h1>
 * <p>
 * 负责调用命令对象执行请求，相关的方法叫做行动方法.在该角色中，需要包含命令对象
 * </p>
 */
public class Invoker
{
    /**
     * 具体的命令对象角色对象
     */
    private Command ca;

    private Command cb;

    private Command cc;

    /**
     * 执行行为
     */
    public void action()
    {
        ca.equals(ca);
    }

    public Command getCa()
    {
        return ca;
    }

    public void setCa(Command ca)
    {
        this.ca = ca;
    }

    public Command getCb()
    {
        return cb;
    }

    public void setCb(Command cb)
    {
        this.cb = cb;
    }

    public Command getCc()
    {
        return cc;
    }

    public void setCc(Command cc)
    {
        this.cc = cc;
    }
}

package com.design.pattern.handler;

/**
 * <h1>具体的责任者角色</h1> <p> 在该角色中，需要显示的指定下一个责任者是谁 </p>
 */
public class ConcreteHanlerB extends Handler
{
    public ConcreteHanlerB(Handler _handler)
    {
        super(_handler);
    }

    @Override
    public boolean handleRequest(Object obj)
    {
        System.out.println("责任链中当前的角色为：" + ConcreteHanlerB.class.getCanonicalName());
        System.out.println("----------------------------");
        if (null == getHandler())
        {
            return false;
        }
        getHandler().handleRequest(obj);
        return true;
    }

}

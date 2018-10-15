package com.design.pattern.state;

public class StateA extends AbstractState
{
    @Override
    public void action(Context context)
    {
        System.out.println("当前状态为" + StateA.class.getCanonicalName());
        System.out.println("下一个状态为" + StateB.class.getCanonicalName());
        System.out.println("---------------------");
        context.setState(new StateB());
    }
}

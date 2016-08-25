package com.design.pattern.state;

public class StateB extends AbstractState
{
    @Override
    public void action(Context context)
    {
        System.out.println("当前状态为" + StateB.class.getCanonicalName());
        System.out.println("下一个状态为" + StateC.class.getCanonicalName());
        System.out.println("---------------------");
        context.setState(new StateC());
    }
}

package com.design.pattern.state;

public class StateC extends AbstractState
{
    @Override
    public void action(Context context)
    {
        context.setState(null);
        System.out.println("当前状态为" + StateC.class.getCanonicalName());
        System.out.println("行为链到此结束");
        System.out.println("---------------------");
    }
}

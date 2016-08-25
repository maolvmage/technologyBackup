package com.design.pattern.state;

public class Main
{
    public static void main(String[] args)
    {
        stateTest();
    }

    public static void stateTest()
    {
        AbstractState state = new StateA();
        Context context = new Context(state);
        boolean isStop = false;
        while (!isStop)
        {
            if (null != context.getState())
                context.action();
            else
                isStop = true;
        }
    }
}

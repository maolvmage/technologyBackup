package com.design.pattern.mediator;

public class Main
{
    public static void main(String[] args)
    {
        new Main().testMediator();
    }

    public void testMediator()
    {
        // 调停者
        Mediator mediator = new ConcreteMediator();
        // 两个被调停者
        Colleague cA = new ConcreteColleagueA(mediator);
        Colleague cB = new ConcreteColleagueB(mediator);
        ((ConcreteMediator) mediator).setConcreteColleagueB(cB);
        ((ConcreteMediator) mediator).setConcreteColleagueA(cA);
        cA.action();
    }

}

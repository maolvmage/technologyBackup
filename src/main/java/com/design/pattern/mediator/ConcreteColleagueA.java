package com.design.pattern.mediator;

/**
 * <h1>具体同事类(ConcreteColleague)角色</h1>
 * <p>
 * 所有的具体同事类均从抽象同事类继承而来。实现自己的业务，
 * <p>
 * <p>
 * 在需要与其他同事通信的时候，就与持有的调停者通信，调停者会负责与其他的同事交互。
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月19日 下午10:29:28
 */
public class ConcreteColleagueA extends Colleague
{
    public ConcreteColleagueA(Mediator mediator)
    {
        super(mediator);
    }

    @Override
    public void action()
    {
        getMediator().change(this);
    }
}

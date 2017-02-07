package com.design.pattern.mediator;

/**
 * <h1>具体调停者(ConcreteMediator)角色</h1>
 * <p>
 * 实现了抽象调停者所声明的事件方法。具体调停者知晓所有的具体同事类，并负责具体的协调各同事对象的交互关系。
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月19日 下午10:35:16
 */
public class ConcreteMediator extends Mediator
{
    /**
     * 同时对象
     */
    private Colleague concreteColleagueA;

    /**
     * 同时对象
     */
    private Colleague concreteColleagueB;

    @Override
    public void change(Colleague colleague)
    {
        if (colleague instanceof ConcreteColleagueA)
        {
            // 此处执行持有该调停者这的对象同其他的同事进行通信
            System.out.println("持有该调停者对象的类名为："
                    + colleague.getClass().getCanonicalName());
            System.out.println("开始让其他的同时对象进行行为");
            this.getConcreteColleagueB().action();
        }
        else if (colleague instanceof ConcreteColleagueB)
        { // 此处执行持有该调停者这的对象同其他的同事进行通信
            System.out.println("持有该调停者对象的类名为："
                    + colleague.getClass().getCanonicalName());
            System.out.println("行为结束");
        }
    }

    public Colleague getConcreteColleagueA()
    {
        return concreteColleagueA;
    }

    public void setConcreteColleagueA(Colleague concreteColleagueA)
    {
        this.concreteColleagueA = concreteColleagueA;
    }

    public Colleague getConcreteColleagueB()
    {
        return concreteColleagueB;
    }

    public void setConcreteColleagueB(Colleague concreteColleagueB)
    {
        this.concreteColleagueB = concreteColleagueB;
    }
}

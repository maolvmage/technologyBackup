package com.design.pattern.observable;


import java.util.Observable;


/**
 * <h1>具体被观察角色</h1> <p> 在JAVA中自带了被观察者角色类java.util.Observable <p> <p> 因此，与业务相关的被观察者角色需要继承该类 <p>
 *
 * @author Administrator
 * @date 2015年7月17日 下午2:04:29
 */
public class ConcreateObservable extends Observable
{
    /**
     * 当前被观察者的状态
     */
    private Object state = "";

    public Object getStat()
    {
        return state;
    }

    /**
     * 改变当前对象的状态
     *
     * @param _state
     *            状态参数
     */
    public void setStat(Object _state)
    {
        if (!state.equals(_state))
        {
            this.state = _state;
            // 标志该被观察者已经改变状态
            setChanged();
            // 通知所有的观察者，对象的状态已经发生变化
            notifyObservers();
        }
    }
}

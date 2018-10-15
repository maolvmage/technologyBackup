package com.design.pattern.observable;


import java.util.Observable;
import java.util.Observer;


/**
 * <h1>具体的观察者的角色</h1> <p> 具体角色需要在该类被访问的时候被添加到具体的被观察者的线程安全的队列中 <p>
 *
 * @author Administrator
 * @date 2015年7月17日 下午2:20:39
 */
public class ConcreateObserver implements Observer
{
    /**
     * 初始化构造方法，规定实例化时，需制定被观察者对象
     *
     * @param o
     *            被观察者对象
     */
    public ConcreateObserver(Observable o)
    {
        o.addObserver(this);
    }

    public void update(Observable o, Object arg)
    {
        System.out.println("状态发生变化，当前的状态为" + ((ConcreateObservable)o).getStat());
    }
}

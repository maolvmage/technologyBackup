package com.design.pattern.observable;

public class Main
{
    public static void main(String[] args)
    {
        observerTest();
    }

    public static void observerTest()
    {
        // 声明被观察者对象
        ConcreateObservable observable = new ConcreateObservable();
        // 生命观察者对象
        @SuppressWarnings("unused")
        ConcreateObserver observer = new ConcreateObserver(observable);
        observable.setStat("init");
        observable.setStat("ready");
        observable.setStat("go");
        observable.setStat("stop");
    }
}

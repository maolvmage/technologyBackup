package com.design.pattern.handler;

public class Main
{
    public static void main(String[] args)
    {
        handlerTest();
    }

    public static void handlerTest()
    {
        Handler c = new ConcreteHanlerC(null);
        Handler b = new ConcreteHanlerB(c);
        Handler a = new ConcreteHanlerA(b);
        a.handleRequest(null);
    }
}

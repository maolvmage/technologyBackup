package com.design.pattern.proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * <h1>动态代理类</h1> <p> 动态代理只能实现实现了接口的类，具有一定的局限性 </p>
 * 
 * @author Administrator
 * @date 2015年7月7日 下午1:56:31
 */
public class DynamicProxy implements InvocationHandler
{
    /**
     * 被代理的对象
     */
    private Object _target;

    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        Object obj = null;
        System.out.println("代理开始前的操作...." + method.getName());
        obj = method.invoke(_target, args);
        System.out.println("代理开始后的操作...." + method.getName());
        return obj;
    }

    public Object generateProxyObject(Object target)
    {
        this._target = target;
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
            target.getClass().getInterfaces(), this);
        return obj;
    }
}

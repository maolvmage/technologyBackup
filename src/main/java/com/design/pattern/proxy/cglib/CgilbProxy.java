package com.design.pattern.proxy.cglib;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * @author Administrator
 * @Description: <h1>cglib代理类</h1>
 * @date 2015年7月7日 下午3:13:43
 */
public class CgilbProxy implements MethodInterceptor
{
    private Object target;

    /**
     * 通过动态代理执行方法
     *
     * @param obj
     *            类对象
     * @param method
     *            方法
     * @param objs
     *            对象组
     * @param methodproxy
     *            方法代理
     * @return 方法返回值
     * @throws Throwable
     */
    public Object intercept(Object obj, Method method, Object[] objs, MethodProxy methodproxy)
        throws Throwable
    {
        Object result = null;
        System.out.println("代理开始前的操作....");
        result = methodproxy.invokeSuper(obj, objs);
        System.out.println("代理开始后的操作....");
        return result;
    }

    /**
     * 创建代理对象
     *
     * @param _target
     *            目标代理对象
     * @return 动态代理对象
     */
    public Object gernerateProxy(Object _target)
    {
        this.target = _target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }
}

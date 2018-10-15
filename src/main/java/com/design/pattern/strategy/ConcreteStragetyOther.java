package com.design.pattern.strategy;

/**
 * <h1>具体策略(ConcreteStrategy)角色</h1> <p> 包装了相关的算法或行为 <p>
 *
 * @author Administrator
 * @date 2015年7月16日 下午4:25:36
 */
public class ConcreteStragetyOther extends AbstractStrategy
{
    @Override
    public void action()
    {
        System.out.println("执行策略" + ConcreteStragetyOther.class.getCanonicalName());
    }

}

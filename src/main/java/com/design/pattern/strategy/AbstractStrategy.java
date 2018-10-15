package com.design.pattern.strategy;

/**
 * <h1>抽象策略(Strategy)角色</h1> <p> 这是一个抽象角色，通常由一个接口或抽象类实现。此角色给出所有的具体策略类所需的接口。 <p>
 *
 * @author Administrator
 * @date 2015年7月16日 下午4:23:39
 */
public abstract class AbstractStrategy
{
    /**
     * 所有策略角色共同具有的行为
     */
    public abstract void action();
}

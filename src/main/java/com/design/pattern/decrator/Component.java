package com.design.pattern.decrator;

/**
 * <h1>抽象构件(Component)角色</h1>
 * <p>
 * 装饰对象以及被装饰对象共同的超类型,给出一个抽象类，以规范准备接收附加责任的对象
 * </p>
 * 
 * @author Administrator
 * @date 2015年7月16日 下午3:44:57
 */
public abstract class Component
{
    /**
     * 装饰对象以及被装饰对象共同的行为
     */
    public abstract void operation();
}

package com.design.pattern.decrator;

/**
 * <h1>具体的装饰类对象</h1>
 * 
 * @author Administrator
 * @date 2015年7月16日 下午3:53:28
 */
public class ConcreteDecoratorOther extends Decorator
{
    /**
     * 该装饰对象的额外的行为对象
     */
    public void addExtendBeahvior()
    {
        System.out.println("添加的额外的行为"
                + ConcreteDecoratorOther.class.getCanonicalName());
    }

    @Override
    public void operation()
    {
        super.operation();
        addExtendBeahvior();
    }
}

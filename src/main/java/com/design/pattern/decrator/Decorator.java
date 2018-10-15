package com.design.pattern.decrator;

/**
 * <h1>装饰的基类</h1> <p> 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口 </p>
 *
 * @author Administrator
 * @date 2015年7月16日 下午3:51:32
 */
public class Decorator extends Component
{
    /**
     * 被装饰的对象
     */
    private Component component;

    @Override
    public void operation()
    {
        component.operation();
    }

    public Component getComponent()
    {
        return component;
    }

    public void setComponent(Component component)
    {
        this.component = component;
    }
}

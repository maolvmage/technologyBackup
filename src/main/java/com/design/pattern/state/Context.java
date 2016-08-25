package com.design.pattern.state;

/**
 * <h1>状态模式的上下文类</h1>
 * <p>
 * 状态的迁移以及行为的变化在此上下文中进行
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月16日 下午9:42:17
 */
public class Context
{
    /**
     * 当前上下文中执行的状态对象
     */
    private AbstractState state;

    /**
     * 构造函数
     * 
     * @param _state
     *            传递的状态参数
     */
    public Context(AbstractState _state)
    {
        this.state = _state;
    }

    /**
     * 执行行为
     */
    public void action()
    {
        this.state.action(this);
    }

    public AbstractState getState()
    {
        return this.state;
    }

    public void setState(AbstractState state)
    {
        this.state = state;
    }
}

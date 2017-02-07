package com.design.pattern.state;

/**
 * <h1>抽象状态角色</h1>
 * <p>
 * 该类将所有变化行为抽象出，具备所有变化行为的共性
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月16日 下午9:47:39
 */
public abstract class AbstractState
{
    /**
     * 执行行为
     */
    public abstract void action(Context context);
}

package com.design.pattern.strategy;

/**
 * <h1>环境(Context)角色</h1>
 * <p>
 * 持有一个Strategy的引用
 * <p>
 * 
 * @author Administrator
 * @date 2015年7月16日 下午4:27:15
 */
public class StragetyContext
{
    /**
     * 策略环境所具备的策略对象
     */
    private AbstractStrategy stragety;

    /**
     * 策略环境角色执行具体策略行为
     */
    public void action()
    {
        // 参数安全性判断
        if (null != stragety)
        {
            stragety.action();
        }
    }

    public AbstractStrategy getStragety()
    {
        return stragety;
    }

    public void setStragety(AbstractStrategy stragety)
    {
        this.stragety = stragety;
    }
}

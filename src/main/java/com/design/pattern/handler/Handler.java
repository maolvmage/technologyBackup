package com.design.pattern.handler;

/**
 * <h1>抽象处理者(Handler)角色</h1> <p> 定义出一个处理请求的接口。如果需要，接口可以定义
 * 出一个方法以设定和返回对下家的引用。这个角色通常由一个Java抽象类或者Java接口实现 </p>
 */
public abstract class Handler
{
    /**
     * 带参构造函数
     *
     * @param _handler
     *            下一个责任者
     */
    public Handler(Handler _handler)
    {
        setHandler(_handler);
    }

    /**
     * 持有的下一个责任者，即责任链中的下一个角色
     */
    private Handler handler;

    /**
     * 处理责任链中的请求
     *
     * @param obj
     *            责任参数
     * @return 是否成功
     */
    public abstract boolean handleRequest(Object obj);

    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }

}

package com.design.pattern.Command;

/**
 * <h1>接受命令者角色</h1>
 * <p>
 * 负责具体实施和执行一个请求。任何一个类都可以成为接收者，实施和执行请求的方法叫做行动方法。
 * </p>
 */
public class Receive
{
    public void action()
    {
        System.out.println("执行相应的命令");
    }
}

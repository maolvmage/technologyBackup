package com.design.pattern.Command;

/**
 * <h1>具体的命令角色</h1> <p> 该角色需要包含具体的执行者角色对象 </p>
 */
public class ConcreteCommandB implements Command
{
    /**
     * 执行命令角色对象
     */
    private Receive receive;

    public ConcreteCommandB(Receive _receive)
    {
        this.receive = _receive;
    }

    public void execute()
    {
        System.out.println("当前执行的命令对象为：" + ConcreteCommandB.class.getCanonicalName());
        receive.action();
    }

}

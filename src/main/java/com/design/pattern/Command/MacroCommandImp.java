package com.design.pattern.Command;


import java.util.concurrent.CopyOnWriteArrayList;


/**
 * <h1>宏命令命令角色--相当于是命令发起者角色</h1> <p> 在该类中实现命令集合的添加命令以及删除命令对象 </p>
 */
public class MacroCommandImp implements MacroCommand
{
    /**
     * 线程安全的命令集合
     */
    private CopyOnWriteArrayList<Command> comandList = new CopyOnWriteArrayList<Command>();

    public void execute()
    {
        // 遍历命令集合中命令，依次执行命令
        for (Command command : comandList)
        {
            command.execute();
        }
    }

    public void add(Command command)
    {
        comandList.add(command);
    }

    public void remove(Command command)
    {
        comandList.remove(command);
    }
}

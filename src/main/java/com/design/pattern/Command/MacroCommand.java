package com.design.pattern.Command;

/**
 * <h1>宏命令抽象命令角色--相当于是抽象命令发起者角色</h1> <p> 此接口定义了存储命令集合的一些公共行为,此接口继承与抽象命令对象 </p>
 */
public interface MacroCommand extends Command
{
    /**
     * 宏命令聚集的管理方法 可以添加一个成员命令
     */
    void add(Command command);

    /**
     * 宏命令聚集的管理方法 可以删除一个成员命令
     */
    void remove(Command command);
}

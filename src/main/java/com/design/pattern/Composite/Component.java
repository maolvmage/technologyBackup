package com.design.pattern.Composite;

/**
 * <h1>抽象的组合角色</h1>
 * <p>
 * 该角色定义了所有节点的(无论是叶子节点还是树枝节点)的默认行为，声明一个接口用于访问和管理Component的子部件
 * </p>
 */

public abstract class Component
{
    /**
     * 添加子组件
     * 
     * @param component
     *            子组件角色
     */
    public abstract void add(Component component);

    /**
     * 删除子部件
     * 
     * @param component
     *            子组件角色
     */
    public abstract void removeComponent(Component component);

    /**
     * 用于该节点的其他操作
     */
    public abstract void action();
}

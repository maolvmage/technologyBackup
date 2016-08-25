package com.design.pattern.Composite;

/**
 * <h1>叶子节点角色</h1>
 * <p>
 * 该节点属于其他的树枝节点，该节点不具备添加和删除节点的功能行为
 * </p>
 */

public class Leaf extends Component
{
    @Override
    public void add(Component component)
    {
        System.out.println("不具备添加功能");
    }

    @Override
    public void removeComponent(Component component)
    {
        System.out.println("不具备添加功能");
    }

    @Override
    public void action()
    {
        System.out.println("执行叶子节点的行为");
    }
}

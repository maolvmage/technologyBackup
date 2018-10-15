package com.design.pattern.Composite;


import java.util.ArrayList;
import java.util.List;


/**
 * <h1>树枝节点角色</h1> <p> 该角色包含一个子集节点的集合 </p>
 */

public class Composite extends Component
{
    /**
     * 该树枝节点具备的子集节点集合
     */
    private List<Component> chilComponents = new ArrayList<Component>();

    @Override
    public void add(Component component)
    {
        chilComponents.add(component);
    }

    @Override
    public void removeComponent(Component component)
    {
        if (chilComponents.contains(component))
        {
            chilComponents.remove(component);
        }
    }

    @Override
    public void action()
    {
        if (chilComponents.isEmpty()) return;
        for (Component component : chilComponents)
        {
            System.out.println("执行" + component.getClass().getCanonicalName() + "角色行为");
            component.action();
        }
    }
}

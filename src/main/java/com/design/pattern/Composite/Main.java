package com.design.pattern.Composite;

/**
 * <h1>用一句话描述</h1> <p> 详细描述 </p>
 */

public class Main
{
    public static void compositeTest()
    {
        // 构造根角色
        Composite root = new Composite();
        // 构造树枝角色
        Composite firstLevelCom = new Composite();
        Composite sercondLevelCom1 = new Composite();
        Composite sercondLevelCom2 = new Composite();
        // 构造叶子节点
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        // 将相应的角色添加到树中，构造整体对象
        root.add(firstLevelCom);
        firstLevelCom.add(sercondLevelCom1);
        firstLevelCom.add(sercondLevelCom2);
        sercondLevelCom1.add(leaf1);
        sercondLevelCom1.add(leaf2);
        root.action();
    }

    public static void main(String[] args)
    {
        compositeTest();
    }
}

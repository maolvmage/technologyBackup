package com.design.pattern.factory.methodFactory.impl;


import com.design.pattern.factory.Product;
import com.design.pattern.factory.ProductB;
import com.design.pattern.factory.methodFactory.AbstractMethodFatory;


/**
 * @author Administrator
 * @Description: <h1>具体工厂角色</h1>
 * @date 2015年7月16日 下午1:26:40
 */
public class FactoryB extends AbstractMethodFatory
{
    @Override
    public Product action()
    {
        System.out.println("实例化产品角色");
        return new ProductB();
    }
}

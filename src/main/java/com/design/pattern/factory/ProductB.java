package com.design.pattern.factory;

/**
 * @Description: <h1>具体产品角色</h1>
 * @author Administrator
 * @date 2015年7月16日 上午10:26:05
 */
public class ProductB extends Product
{
    @Override
    public void action()
    {
        System.out.println("生产产品B");
    }
}

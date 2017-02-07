package com.design.pattern.factory.simpleFactory;

import com.design.pattern.factory.Product;
import com.design.pattern.factory.ProductA;
import com.design.pattern.factory.ProductB;

/**
 * @Description: <h1>工厂类角色</h1>
 *               <p>
 *               在该类中包含一定的业务逻辑的判断
 *               </p>
 * @author Administrator
 * @date 2015年7月16日 上午10:24:36
 */
public class SimpleFactory
{
    /**
     * 执行行为
     * 
     * @param type
     *            类型
     */
    public static void executeAction(String type)
    {
        // 抽象对象
        Product obj = null;
        if (type.equals("A"))
            obj = new ProductA();
        else if (type.equals("B"))
            obj = new ProductB();
        // 执行行为
        obj.action();
    }
}

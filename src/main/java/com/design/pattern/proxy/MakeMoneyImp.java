package com.design.pattern.proxy;


import com.design.pattern.proxy.dynamicProxy.MakeMoneyInte;


/**
 * @author Administrator
 * @Description: <h1>动态代理的实现类</h1>
 * @date 2015年7月7日 下午1:54:51
 */
public class MakeMoneyImp implements MakeMoneyInte
{

    public void earnMoney(int many)
    {
        System.out.println("挣到的钱为：" + many);
    }
}

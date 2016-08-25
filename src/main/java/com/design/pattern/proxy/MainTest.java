package com.design.pattern.proxy;

import com.design.pattern.proxy.cglib.CgilbProxy;
import com.design.pattern.proxy.dynamicProxy.DynamicProxy;
import com.design.pattern.proxy.dynamicProxy.MakeMoneyInte;

/**
 * @Description <h1>测试类</h1>
 * @author Administrator
 * @date 2015年7月7日 下午2:09:53
 */
public class MainTest {
	public static void main(String[] args) {
		testCglibProxy();
		// testDynamicProxy();
	}

	public static void testDynamicProxy() {
		MakeMoneyImp imp = new MakeMoneyImp();
		DynamicProxy proxy = new DynamicProxy();
		MakeMoneyInte inte = (MakeMoneyInte) proxy.generateProxyObject(imp);
		inte.earnMoney(10000);
	}

	public static void testCglibProxy() {
		CgilbProxy proxy = new CgilbProxy();
		MakeMoneyImp imp = (MakeMoneyImp) proxy
				.gernerateProxy(new MakeMoneyImp());
		imp.earnMoney(10000);
	}
}

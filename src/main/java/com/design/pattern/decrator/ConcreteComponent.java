package com.design.pattern.decrator;

/**
 * <h1>具体构件(ConcreteComponent)角色</h1> <p> 定义一个将要接收附加责任的类 </p>
 *
 * @author Administrator
 * @date 2015年7月16日 下午4:03:07
 */
public class ConcreteComponent extends Component
{
    @Override
    public void operation()
    {
        // 具体构件类的实际起始行为点
        System.out.println("具体行为从此处开始");
    }
}

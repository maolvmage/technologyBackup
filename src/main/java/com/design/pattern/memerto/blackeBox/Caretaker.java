package com.design.pattern.memerto.blackeBox;

import com.design.pattern.memerto.MementoIF;

/**
 * <h1>负责人（Caretaker）角色</h1>
 * <p>
 * （1）负责保存备忘录对象,负责人对象持有一个备忘录对象
 * </p>
 * <p>
 * （2）不检查备忘录对象的内容。
 * </p>
 */
public class Caretaker
{
    /**
     * 持有的备忘录对象，因为非抽象的备忘录类为私有内部类，不能被外部访问，因此，此处申明的类型为一个接口
     */
    private MementoIF memento;

    /**
     * 保存备忘录对象
     * 
     * @param _memento
     *            继承了窄接口的备忘录对象
     */
    public void saveMemento(MementoIF _memento)
    {
        this.memento = _memento;
    }

    /**
     * 备忘录取值方法
     * 
     * @return 该负责人保存的备忘录对象
     */
    public MementoIF retrieveMemento()
    {
        return this.memento;
    }
}

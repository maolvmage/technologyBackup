package com.design.pattern.memerto.blackeBox;

import com.design.pattern.memerto.MementoIF;

/**
 * <h1>发起人（Originator）角色</h1>
 * <p>
 * （1）创建一个含有当前的内部状态的备忘录对象。
 * <p>
 * <p>
 * （2）使用备忘录对象存储其内部状态。
 * </p>
 */
public class Originator
{
    /**
     * 状态
     */
    private String state;

    public String getState()
    {
        return state;
    }

    public void setState(String _state)
    {
        System.out.println("赋值的状态为：" + _state);
        this.state = _state;
    }

    /**
     * 创建一个新的备忘录对象
     * 
     * @return 备忘录对象
     */
    public Memento createMemento()
    {
        return new Memento(getState());
    }

    /**
     * 将发起者的状态恢复到存储的状态
     * 
     * @param memento
     *            备忘录对象
     */
    public void restoreMemento(MementoIF memento)
    {
        setState(((Memento) memento).getState());
    }

    /**
     * <h1>发起者中定义的备忘内部类</h1>
     * <p>
     * 详细描述
     * </p>
     */
    private class Memento implements MementoIF
    {
        private String state;

        /**
         * 构造函数
         * 
         * @param _state
         *            传递的发起者的状态
         */
        public Memento(String _state)
        {
            setState(_state);
        }

        private String getState()
        {
            return state;
        }

        private void setState(String state)
        {
            this.state = state;
        }
    }
}

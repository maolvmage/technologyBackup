package com.design.pattern.memerto;

import com.design.pattern.memerto.blackeBox.Caretaker;
import com.design.pattern.memerto.blackeBox.Originator;

public class Main
{
    public static void main(String[] args)
    {
        blackBoxMemento();
    }

    public static void blackBoxMemento()
    {
        // 定义负责人
        Caretaker careTaker = new Caretaker();
        // 定义发起人
        Originator originator = new Originator();
        originator.setState("ON");
        // 创建一个备忘录对象
        MementoIF mementoIF = originator.createMemento();
        // 将备忘录对象添加到负责人中
        careTaker.saveMemento(mementoIF);
        originator.setState("OFF");
        System.out.println("当前的发起人的状态为:" + originator.getState());
        originator.restoreMemento(careTaker.retrieveMemento());
    }
}

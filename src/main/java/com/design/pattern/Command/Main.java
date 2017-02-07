package com.design.pattern.Command;

public class Main
{
    public static void main(String[] args)
    {
        testCommand();
    }

    public static void testCommand()
    {
        Receive receive = new Receive();
        Command c1 = new ConcreteCommandA(receive);
        Command c2 = new ConcreteCommandB(receive);
        Command c3 = new ConcreteCommandC(receive);
        MacroCommand macroCommand = new MacroCommandImp();
        macroCommand.add(c1);
        macroCommand.add(c2);
        macroCommand.add(c3);
        macroCommand.execute();
    }
}

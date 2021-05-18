package CommandPatternExample.complex;

import CommandPatternExample.simple.Command;

public class ComplexRemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public ComplexRemoteControl() {
        onCommands = new Command[4];
        offCommands = new Command[4];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 4; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("[slot ").append(i).append("] ").append(onCommands[i].getClass().getName()).append(" ").append(offCommands[i].getClass().getName()).append("\n");
        }
        return stringBuilder.toString();
    }
}

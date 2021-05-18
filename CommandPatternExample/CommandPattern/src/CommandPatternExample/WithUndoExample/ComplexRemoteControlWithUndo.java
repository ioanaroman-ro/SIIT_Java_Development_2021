package CommandPatternExample.WithUndoExample;

public class ComplexRemoteControlWithUndo {
    CommandWithUndo[] onCommands;
    CommandWithUndo[] offCommands;
    CommandWithUndo undoCommand;

    public ComplexRemoteControlWithUndo() {
        onCommands = new CommandWithUndo[2];
        offCommands = new CommandWithUndo[2];
        CommandWithUndo noCommand = new NoCommandWithUndo();
        for (int i = 0; i < 2; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, CommandWithUndo onCommand, CommandWithUndo offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("[slot ").append(i).append("] ").
                    append(onCommands[i].getClass().getName()).append(" ").
                    append(offCommands[i].getClass().getName()).append("\n");
        }
        stringBuilder.append(undoCommand.getClass().getName());
        return stringBuilder.toString();
    }
}

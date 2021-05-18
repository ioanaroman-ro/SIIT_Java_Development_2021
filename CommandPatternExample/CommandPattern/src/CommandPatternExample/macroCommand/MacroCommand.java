package CommandPatternExample.macroCommand;

import CommandPatternExample.simple.Command;

public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    public void execute() {
        System.out.println("----------------------");
        System.out.println("Macrocommand executed.");
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }

    }
}

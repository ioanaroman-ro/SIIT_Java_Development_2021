package CommandPatternExample.WithUndoExample;

import model.SimpleLight;

public class LightOnCommandWithUndo implements CommandWithUndo {
    SimpleLight light;

    public LightOnCommandWithUndo(SimpleLight light) {
        this.light = light;
    }

    public void execute() {
        light.on();
        System.out.println(this.light.getName() + " light on.");
    }

    public void undo() {
        light.off();
        System.out.println(this.light.getName() + " light off.");
    }


}

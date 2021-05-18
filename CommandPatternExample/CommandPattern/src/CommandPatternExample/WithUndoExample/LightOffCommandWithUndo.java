package CommandPatternExample.WithUndoExample;

import model.SimpleLight;

public class LightOffCommandWithUndo implements CommandWithUndo {
    SimpleLight light;

    public LightOffCommandWithUndo(SimpleLight light) {
        this.light = light;
    }

    public void execute() {
        light.off();
        System.out.println(this.light.getName() + " light off.");
    }

    public void undo() {
        light.on();
        System.out.println(this.light.getName() + " light on.");
    }

}

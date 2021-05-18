package CommandPatternExample.simple;

import model.SimpleLight;

public class LightOnCommand implements Command {
    SimpleLight light;

    public LightOnCommand(SimpleLight light) {
        this.light = light;
    }

    public void execute() {
        light.on();
        System.out.println(this.light.getName() + " light on.");
    }

}

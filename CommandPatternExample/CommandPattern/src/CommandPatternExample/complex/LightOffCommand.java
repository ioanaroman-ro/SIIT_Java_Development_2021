package CommandPatternExample.complex;

import CommandPatternExample.simple.Command;
import model.SimpleLight;

public class LightOffCommand implements Command {
    SimpleLight light;

    public LightOffCommand(SimpleLight light) {
        this.light = light;
    }

    public void execute() {
        light.off();
        System.out.println(this.light.getName() + " light off.");
    }

}

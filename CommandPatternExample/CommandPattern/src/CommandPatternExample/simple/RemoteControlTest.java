package CommandPatternExample.simple;

import model.SimpleLight;
import model.VacuumCleaner;

public class RemoteControlTest {

    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        SimpleLight light = new SimpleLight("Kitchen");
        VacuumCleaner vacuum = new VacuumCleaner("Robot cleaner");
        LightOnCommand lightOn = new LightOnCommand(light);
        VacuumCleanerOnCommand vacuumOn = new VacuumCleanerOnCommand(vacuum);
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        remote.setCommand(vacuumOn);
        remote.buttonWasPressed();
    }
}

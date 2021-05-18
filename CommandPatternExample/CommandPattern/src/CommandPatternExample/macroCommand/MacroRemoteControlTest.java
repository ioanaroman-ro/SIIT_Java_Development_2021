package CommandPatternExample.macroCommand;

import CommandPatternExample.complex.ComplexRemoteControl;
import CommandPatternExample.complex.LightOffCommand;
import CommandPatternExample.complex.VacuumCleanerOffCommand;
import CommandPatternExample.simple.*;
import model.SimpleLight;
import model.VacuumCleaner;

public class MacroRemoteControlTest {
    public static void main(String[] args) {
        ComplexRemoteControl remoteControl = new ComplexRemoteControl();

        SimpleLight livingRoomLight = new SimpleLight("Living Room");
        SimpleLight kitchenLight = new SimpleLight("Kitchen");
        VacuumCleaner vacuumCleaner = new VacuumCleaner("Robot cleaner");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        VacuumCleanerOnCommand vacuumCleanerOn = new VacuumCleanerOnCommand(vacuumCleaner);
        VacuumCleanerOffCommand vacuumCleanerOff = new VacuumCleanerOffCommand(vacuumCleaner);


        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, vacuumCleanerOn, vacuumCleanerOff);


        Command[] atHome = {livingRoomLightOn, kitchenLightOn, vacuumCleanerOff};
        Command[] leavingHome = {livingRoomLightOff, kitchenLightOff, vacuumCleanerOn};
        MacroCommand atHomeMacro = new MacroCommand(atHome);
        MacroCommand leavingHomeMacro = new MacroCommand(leavingHome);

        remoteControl.setCommand(3, atHomeMacro, leavingHomeMacro);

        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}

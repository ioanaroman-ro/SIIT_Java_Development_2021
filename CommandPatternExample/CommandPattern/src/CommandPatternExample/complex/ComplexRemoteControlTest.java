package CommandPatternExample.complex;

import CommandPatternExample.simple.LightOnCommand;
import CommandPatternExample.simple.VacuumCleanerOnCommand;
import model.SimpleLight;
import model.VacuumCleaner;

public class ComplexRemoteControlTest {
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

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);


    }
}

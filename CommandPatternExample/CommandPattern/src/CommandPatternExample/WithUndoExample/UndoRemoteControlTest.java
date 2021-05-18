package CommandPatternExample.WithUndoExample;


import model.SimpleLight;

public class UndoRemoteControlTest {
    public static void main(String[] args) {
        ComplexRemoteControlWithUndo remoteControl = new ComplexRemoteControlWithUndo();

        SimpleLight livingRoomLight = new SimpleLight("Living Room");

        LightOnCommandWithUndo livingRoomLightOn = new LightOnCommandWithUndo(livingRoomLight);
        LightOffCommandWithUndo livingRoomLightOff = new LightOffCommandWithUndo(livingRoomLight);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);

        System.out.println(remoteControl);
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        System.out.println("Undo pushed.");
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(0);
        System.out.println(remoteControl);
        System.out.println("Undo pushed.");
        remoteControl.undoButtonWasPushed();

    }
}

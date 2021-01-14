import commands.LightOffCommand;
import commands.LightOnCommand;
import commands.StereoOffCommand;
import commands.StereoOnWithCDCommand;
import light.Light;
import stereo.Stereo;

public class RemoteTester {
    public static void main(String[] args) {
        Light kitchenLight = new Light("Kitchen");
        Light livingRoomLight = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand lightOnCommand = new LightOnCommand(kitchenLight);
        LightOnCommand lightOnCommand1 = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOffCommand = new LightOffCommand(kitchenLight);
        LightOffCommand lightOffCommand1 = new LightOffCommand(livingRoomLight);

        StereoOnWithCDCommand stereoOnWithCDCommand  = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(1, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(2, lightOnCommand1, lightOffCommand1);
        remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        remoteControl.onButtonWasPushed(8);
        remoteControl.offButtonWasPushed(8);
    }
}

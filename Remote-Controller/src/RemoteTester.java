import ceilingfan.CeilingFan;
import commands.CeilingFanHighCommand;
import commands.CeilingFanOffCommand;
import commands.Command;
import commands.LightOffCommand;
import commands.LightOnCommand;
import commands.MacroCommand;
import commands.StereoOffCommand;
import commands.StereoOnWithCDCommand;
import light.Light;
import stereo.Stereo;

public class RemoteTester {
    public static void main(String[] args) {
        Light kitchenLight = new Light("Kitchen");
        Light livingRoomLight = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");
        CeilingFan ceilingFan = new CeilingFan("Hall");

        LightOnCommand lightOnCommand = new LightOnCommand(kitchenLight);
        LightOnCommand lightOnCommand1 = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOffCommand = new LightOffCommand(kitchenLight);
        LightOffCommand lightOffCommand1 = new LightOffCommand(livingRoomLight);

        StereoOnWithCDCommand stereoOnWithCDCommand  = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        RemoteControl remoteControl = new RemoteControl();

//        use of lambdas if Command interface was a functional interface
//        remoteControl.setCommand(1, kitchenLight::on, kitchenLight::off);
//        remoteControl.setCommand(2, livingRoomLight::on, livingRoomLight::off);
//        remoteControl.setCommand(3, stereo::on, stereo::off);

        remoteControl.setCommand(1, lightOnCommand, lightOffCommand);
        remoteControl.setCommand(2, lightOnCommand1, lightOffCommand1);
        remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffCommand);
        remoteControl.setCommand(4, ceilingFanHighCommand, ceilingFanOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
        remoteControl.onButtonWasPushed(8);
        remoteControl.offButtonWasPushed(8);

        remoteControl.onButtonWasPushed(4);
        remoteControl.offButtonWasPushed(4);
        remoteControl.undoButtonWasPushed();

        Command[] partyOn = { lightOnCommand1, stereoOnWithCDCommand, ceilingFanHighCommand};
        Command[] partyEnd = { lightOffCommand1, stereoOffCommand, ceilingFanOffCommand };
        MacroCommand partyOnCommand = new MacroCommand(partyOn);
        MacroCommand partyEndCommand = new MacroCommand(partyEnd);

        System.out.println("\n\nLet the Party Begin :)");
        remoteControl.setCommand(5, partyOnCommand, partyEndCommand);
        remoteControl.onButtonWasPushed(5);
        System.out.println("\n\nEnd of party :(");
        remoteControl.offButtonWasPushed(5);
    }
    /**
     * More use cases of Command Pattern
     * 1. Commands give us a way to package a piece of computation (a receiver and a set of actions) and pass it around as a first-class object
     *    Imagine a job queue: you add commands to the queue on one end, and on the other end sits a group of threads. Threads run the following script:
     *      they remove a command from the queue,
     *      call its execute() method,
     *      wait for the call to finish,
     *      and then discard the command object and retrieve a new one.
     *      so it can be used in  schedulers, thread pools, and job queues
     * 2. When needed to run transactions each commands inside the transaction can be broken
     *    down to similar type of such commands and when we proceed with execution we store the order if
     *    crash was supposed to happen we undo the commands in the same order to reverse the transaction
     */
}

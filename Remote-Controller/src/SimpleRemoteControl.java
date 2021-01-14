import commands.Command;
import commands.LightOnCommand;
import light.Light;

// Simple with only one slot
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {

    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    // Testing the Simple Remote Controller Code
    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light("Kitchen");
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        simpleRemoteControl.setCommand(lightOnCommand);

        simpleRemoteControl.buttonWasPressed();
    }
}

import commands.Command;
import commands.NoCommand;

public class RemoteControl {
    public static int NO_OF_BUTTONS = 7;
    Command[] onCommands;
    Command[] offCommands;
    Command noCommand;

    public RemoteControl() {
        onCommands = new Command[NO_OF_BUTTONS];
        offCommands = new Command[NO_OF_BUTTONS];
        noCommand = new NoCommand();

        for(int i=0; i<NO_OF_BUTTONS; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
    private boolean isValidSlot(int slot) {
        return slot > 0 && slot <= NO_OF_BUTTONS;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if(isValidSlot(slot)) {
            onCommands[slot-1] = onCommand;
            offCommands[slot-1] = offCommand;
            return;
        }
        System.err.println("Error: Invalid Slot " + slot);
    }

    public void onButtonWasPushed(int slot) {
        if(isValidSlot(slot)) {
            onCommands[slot].execute();
            return;
        }
        System.err.println("Error: Invalid Slot " + slot);
    }

    public void offButtonWasPushed(int slot) {
        if(isValidSlot(slot)) {
            offCommands[slot].execute();
            return;
        }
        System.err.println("Error: Invalid Slot " + slot);
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n---------------Remote Control-----------------\n");
        for(int i=0; i<NO_OF_BUTTONS; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() +
                    "   " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuff.toString();
    }
}

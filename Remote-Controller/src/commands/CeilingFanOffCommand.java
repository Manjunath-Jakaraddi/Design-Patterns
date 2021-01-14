package commands;

import ceilingfan.CeilingFan;

public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    // store the prev state information if undo command is used
    int prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.setOff();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(prevSpeed);
    }
}

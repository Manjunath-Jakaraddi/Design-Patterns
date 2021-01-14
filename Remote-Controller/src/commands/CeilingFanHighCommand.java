package commands;

import ceilingfan.CeilingFan;

public class CeilingFanHighCommand implements Command{
    CeilingFan ceilingFan;
    // store the prev state information if undo command is used
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.setHigh();
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(prevSpeed);
    }
}

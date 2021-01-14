package ceilingfan;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String name;
    int speed;
    public CeilingFan(String name) {
        this.name = name;
        speed = OFF;
    }

    public void setHigh() {
        speed = HIGH;
        System.out.println(name + " fan set to " + speed + " speed");
    }

    public void setMedium() {
        speed = MEDIUM;
        System.out.println(name + " fan set to " + speed + " speed");
    }

    public void setLow() {
        speed = LOW;
        System.out.println(name + " fan set to " + speed + " speed");
    }

    public void setOff() {
        speed = OFF;
        System.out.println(name + " fan turned off");
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

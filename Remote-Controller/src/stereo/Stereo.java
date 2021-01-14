package stereo;

public class Stereo {
    private String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(name + " stereo turned on");
    }

    public void setCD() {
        System.out.println("CD put into " + name + " stereo");
    }

    public void setVolume(int volume) {
        System.out.println(name + " stereo Volume set to " + volume);
    }

    public void off() {
        System.out.println(name + " stereo turned off");
    }
}

package ducks;

public class RedHeadDuck extends Duck implements Flyable {
    public void quack() {
        System.out.println("RedHeadDuck Duck Quack");
    }

    public void display() {
        System.out.println("RedHeadDuck Duck Display");
    }

    public void fly() {
        System.out.println("General Duck Fly");
    }
}

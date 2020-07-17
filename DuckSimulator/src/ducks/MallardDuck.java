package ducks;

public class MallardDuck extends Duck implements Flyable {
    public void quack() {
        System.out.println("Mallard Duck Quack");
    }

    public void display() {
        System.out.println("Mallard Duck Display");
    }

    public void fly() {
        System.out.println("General Duck Fly");
    }
}

package ducks;

import ducks.fly.FlyWithWings;
import ducks.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    public void display() {
        System.out.println("Mallard Duck Display");
    }
}

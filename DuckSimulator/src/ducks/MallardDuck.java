package ducks;

import ducks.fly.FlyWithWings;
import ducks.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    public String display() {
        return "Mallard Duck Display";
    }
}

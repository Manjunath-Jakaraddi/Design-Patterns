package ducks;

import ducks.fly.FlyWithWings;
import ducks.quack.Quack;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new Quack();
    }

    public String display() {
        return "RedHead Duck Display";
    }
}

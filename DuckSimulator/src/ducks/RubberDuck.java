package ducks;

import ducks.fly.FlyNoWay;
import ducks.quack.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehaviour =  new FlyNoWay();
        quackBehaviour = new Squeak();
    }

    public void display() {
        System.out.println("RubberDuck Duck Display");
    }
}

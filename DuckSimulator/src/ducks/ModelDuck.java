package ducks;

import ducks.fly.FlyNoWay;
import ducks.quack.MuteQuack;

public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehaviour = new FlyNoWay();
        quackBehaviour = new MuteQuack();
    }

    public void display() {
        System.out.println("ModelDuck Display");
    }
}

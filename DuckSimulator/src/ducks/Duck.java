package ducks;

import ducks.fly.FlyBehaviour;
import ducks.quack.QuackBehaviour;

public class Duck {

    QuackBehaviour quackBehaviour;
    FlyBehaviour flyBehaviour;

    // Duck class no longer handles below behaviours and delegates them
    // which has flexibility to assign and change behaviours during run times
    public void performQuack() {
        quackBehaviour.quack();
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void display() {
        System.out.println("General Duck Display");
    }

    public void swim() {
        System.out.println("General Duck float");
    }
}

package ducks;

import ducks.fly.FlyBehaviour;
import ducks.quack.QuackBehaviour;

public class Duck {

    QuackBehaviour quackBehaviour;
    FlyBehaviour flyBehaviour;

    // Duck class no longer handles below behaviours and delegates them
    // which has flexibility to assign and change behaviours during run times
    public String performQuack() {
        return quackBehaviour.quack();
    }

    public String performFly() {
        return flyBehaviour.fly();
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public String display() {
        return "General Duck Display";
    }

    public String swim() {
        return "General Duck float";
    }
}

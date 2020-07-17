package ducks.fly;

public class FlyNoWay implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("Not able to Fly");
    }
}

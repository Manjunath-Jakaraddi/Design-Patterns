package ducks.fly;

public class FlyNoWay implements FlyBehaviour{
    @Override
    public String fly() {
        return "Not able to Fly";
    }
}

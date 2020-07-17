import ducks.Duck;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;

public class Application {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.quack();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.fly();

        Duck redheadDuck = new RedHeadDuck();
        redheadDuck.quack();
        redheadDuck.display();
        redheadDuck.swim();
        redheadDuck.fly();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.quack();
        rubberDuck.display();
        rubberDuck.swim();
        rubberDuck.fly();
    }
}

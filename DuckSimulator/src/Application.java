import ducks.Duck;
import ducks.MallardDuck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;

public class Application {
    public static void main(String[] args) {
        // Can change dynamically the fly and quack behavious at run time
        // code reuse included as no same multiple different fly methods for each duck
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        mallardDuck.display();
        mallardDuck.swim();

        Duck redheadDuck = new RedHeadDuck();
        redheadDuck.performFly();
        redheadDuck.performQuack();
        redheadDuck.display();
        redheadDuck.swim();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        rubberDuck.display();
        rubberDuck.swim();
    }
}

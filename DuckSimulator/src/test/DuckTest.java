package test;
import ducks.Duck;
import ducks.MallardDuck;
import ducks.ModelDuck;
import ducks.RedHeadDuck;
import ducks.RubberDuck;
import ducks.fly.FlyRocketPowered;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuckTest {

    @Test
    public void testMallardDuck() {
        Duck mallardDuck = new MallardDuck();
        assertEquals(mallardDuck.performQuack(), "Quack Quack");
        assertEquals(mallardDuck.performFly(), "Fly with Wings");
        assertEquals(mallardDuck.display(), "Mallard Duck Display");
        assertEquals(mallardDuck.swim(), "General Duck float");
    }

    @Test
    public void testRedHeadDuck() {
        Duck redHeadDuck = new RedHeadDuck();
        assertEquals(redHeadDuck.performQuack(), "Quack Quack");
        assertEquals(redHeadDuck.performFly(), "Fly with Wings");
        assertEquals(redHeadDuck.display(), "RedHead Duck Display");
        assertEquals(redHeadDuck.swim(), "General Duck float");
    }

    @Test
    public void testRubberDuck() {
        Duck rubberDuck = new RubberDuck();
        assertEquals(rubberDuck.performQuack(), "Squeak Squeak");
        assertEquals(rubberDuck.performFly(), "Not able to Fly");
        assertEquals(rubberDuck.display(), "RubberDuck Duck Display");
        assertEquals(rubberDuck.swim(), "General Duck float");
    }

    @Test
    public void testModelDuck() {
        Duck modelDuck = new ModelDuck();
        assertEquals(modelDuck.performQuack(), "Silent no Quack");
        assertEquals(modelDuck.performFly(), "Not able to Fly");
        assertEquals(modelDuck.display(), "Model Duck Display");
        assertEquals(modelDuck.swim(), "General Duck float");

        modelDuck.setFlyBehaviour(new FlyRocketPowered());

        assertEquals(modelDuck.performFly(), "Fly like rocket");
    }
}

package pizza.ingredients;

import pizza.dough.Dough;
import pizza.dough.ThickCrustDough;
import pizza.sauce.PlumTomatoSauce;
import pizza.sauce.Sauce;
import pizza.toppings.Mushroom;
import pizza.toppings.RedPepper;
import pizza.toppings.Topping;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Topping[] createToppings() {
        Topping[] toppings = {new Mushroom(), new RedPepper() };
        return toppings;
    }
}

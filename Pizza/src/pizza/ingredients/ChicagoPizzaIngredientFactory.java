package pizza.ingredients;

import pizza.ingredients.dough.Dough;
import pizza.ingredients.dough.ThickCrustDough;
import pizza.ingredients.sauce.PlumTomatoSauce;
import pizza.ingredients.sauce.Sauce;
import pizza.ingredients.toppings.Mushroom;
import pizza.ingredients.toppings.RedPepper;
import pizza.ingredients.toppings.Topping;

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

package pizza.ingredients;

import pizza.ingredients.dough.Dough;
import pizza.ingredients.dough.ThinCrustDough;
import pizza.ingredients.sauce.MarinaraSauce;
import pizza.ingredients.sauce.Sauce;
import pizza.ingredients.toppings.Garlic;
import pizza.ingredients.toppings.Onion;
import pizza.ingredients.toppings.Topping;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Topping[] createToppings() {
        Topping[] toppings = {new Onion(), new Garlic() };
        return toppings;
    }
}

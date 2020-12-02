package pizza.ingredients;

import pizza.dough.Dough;
import pizza.dough.ThinCrustDough;
import pizza.sauce.MarinaraSauce;
import pizza.sauce.Sauce;
import pizza.toppings.Garlic;
import pizza.toppings.Onion;
import pizza.toppings.Topping;

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

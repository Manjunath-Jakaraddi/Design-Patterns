package pizza.ingredients;

import pizza.dough.Dough;
import pizza.sauce.Sauce;
import pizza.toppings.Topping;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Topping[] createToppings();
}

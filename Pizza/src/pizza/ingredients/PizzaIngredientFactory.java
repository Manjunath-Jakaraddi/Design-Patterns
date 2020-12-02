package pizza.ingredients;

import pizza.ingredients.dough.Dough;
import pizza.ingredients.sauce.Sauce;
import pizza.ingredients.toppings.Topping;

public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Topping[] createToppings();
}

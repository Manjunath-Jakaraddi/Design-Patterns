import pizza.CheesePizza;
import pizza.Pizza;
import pizza.ingredients.NYPizzaIngredientFactory;
import pizza.ingredients.PizzaIngredientFactory;

public class NYStylePizzaStore extends PizzaStore {
    PizzaIngredientFactory ingredientFactory;

    public NYStylePizzaStore() {
        ingredientFactory = new NYPizzaIngredientFactory();
    }
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new CheesePizza(ingredientFactory);
        }
        return null;
    }
}

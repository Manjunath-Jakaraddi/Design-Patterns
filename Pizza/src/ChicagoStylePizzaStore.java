import pizza.GreekPizza;
import pizza.Pizza;
import pizza.ingredients.ChicagoPizzaIngredientFactory;
import pizza.ingredients.PizzaIngredientFactory;

public class ChicagoStylePizzaStore extends PizzaStore {
    PizzaIngredientFactory ingredientFactory;

    public ChicagoStylePizzaStore() {
        ingredientFactory = new ChicagoPizzaIngredientFactory();
    }
    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new GreekPizza(ingredientFactory);
        }
        return null;
    }
}

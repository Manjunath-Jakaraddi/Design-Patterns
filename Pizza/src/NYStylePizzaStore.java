import pizza.NYStyleCheesePizza;
import pizza.Pizza;

public class NYStylePizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {

        if(type.equals("cheese")) {
            return new NYStyleCheesePizza();
        }
        return null;
    }
}

import pizza.NYStyleCheesePizza;
import pizza.Pizza;

public class NYPizzaFactory extends SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        // can modified whenever a pizza is added or removed from menu
        if(type.equals("cheese")) {
            pizza = new NYStyleCheesePizza();
        }

        return pizza;
    }
}

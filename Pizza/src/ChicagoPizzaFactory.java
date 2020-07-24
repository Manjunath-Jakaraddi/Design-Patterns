import pizza.ChicagoStyleCheesePizza;
import pizza.Pizza;

public class ChicagoPizzaFactory extends SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        // can modified whenever a pizza is added or removed from menu
        if(type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza();
        }

        return pizza;
    }
}

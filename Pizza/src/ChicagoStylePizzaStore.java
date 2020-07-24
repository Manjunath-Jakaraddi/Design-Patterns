import pizza.ChicagoStyleCheesePizza;
import pizza.Pizza;

public class ChicagoStylePizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if(type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        }
        return null;
    }
}

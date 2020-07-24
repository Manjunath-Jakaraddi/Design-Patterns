import pizza.CheesePizza;
import pizza.Pizza;

public class Application {
    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.orderPizza("cheese");
        pizza.orderPizza("greek");
    }
}

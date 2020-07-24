import pizza.Pizza;

public class Application {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");

        PizzaStore chicagoStore = new ChicagoStylePizzaStore();
        Pizza pizza1 = chicagoStore.orderPizza("cheese");

    }
}

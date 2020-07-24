public class Application {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(factory);

        // Now the pizza business has grown and we want to
        // add franchise like NYstyled pizzas and ChicagoStyles
        pizzaStore.orderPizza("cheese");
        pizzaStore.orderPizza("greek");
    }
}

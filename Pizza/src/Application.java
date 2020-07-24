import pizza.Pizza;

public class Application {
    public static void main(String[] args) {
        NYPizzaFactory nyFactory = new NYPizzaFactory();
        PizzaStore nyStore = new PizzaStore(nyFactory);
        Pizza pizza = nyStore.orderPizza("cheese");
        /**
         * Preparing NY style sauce and Cheese Pizza
         * Tossing dough...
         * Adding sauce...
         * Adding toppings: Grated Reggiano cheese
         * Bake for 25 minutes at 350
         * Cutting the pizza into diagonal pieces
         * Place pizza in official PizzaStore box
         */

        ChicagoPizzaFactory chicagoFactory = new ChicagoPizzaFactory();
        PizzaStore chicagoStore = new PizzaStore(chicagoFactory);
        Pizza pizza1 = chicagoStore.orderPizza("cheese");
        /**
         *          Preparing Chicago styled deep dish Cheese Pizza
         *         Tossing dough...
         *         Adding sauce...
         *         Adding toppings: Shredded mozarella cheese
         *         Bake for 25 minutes at 350
         *         Cutting the pizza into square slices
         *         Place pizza in third party PizzaStore box
         */

    }
}

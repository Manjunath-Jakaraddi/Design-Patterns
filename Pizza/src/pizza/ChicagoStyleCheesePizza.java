package pizza;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago styled deep dish Cheese Pizza";
        dough = "Extra thick crust dough";
        sauce = "Plum tomato sauce";

        toppings.add("Shredded mozarella cheese");
    }

    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

    // what if the the frachises started to pack pizza in third party boxes
    // not follow the way of handling the pizza orders
    // to standardise this there should be constraints on the certain functions
    // should be called while preparing pizzas at the same time flexiblity also
    // to be given to franchises to be able to modify
    public void box() {
        System.out.println("Place pizza in third party PizzaStore box");
    }
}

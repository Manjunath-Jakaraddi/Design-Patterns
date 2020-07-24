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

}

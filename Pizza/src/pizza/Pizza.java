package pizza;

import java.util.ArrayList;

public class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    private void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.print("Adding toppings:");
        for(String topping: toppings) {
            System.out.print(" " + topping);
        }
        System.out.println();
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal pieces");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    // As creating new pizza type is variable thing have to seperate it out
    // Identifying aspects that vary and seperate them
    public Pizza orderPizza(String type) {
        Pizza pizza = null;

        // need to be modified whenever a pizza is added or removed from menu
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if(type.equals("greek")) {
            pizza = new GreekPizza();
        }

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}

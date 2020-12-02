package pizza;

import pizza.ingredients.PizzaIngredientFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheesePizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;

        name = "Cheese Pizza";
    }

    @Override
    public void prepare() {
        // creating NY Style Cheese Pizza at runtime
        // can be of any regions Cheese Pizza based on the ingredient Factory passed
        dough = ingredientFactory.createDough().getDough();
        sauce = ingredientFactory.createSauce().getSauce();
        toppings = Arrays.stream(ingredientFactory.createToppings()).map(topping -> topping.getTopping()).collect(Collectors.toList());


        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.print("Adding toppings:");
        for(String topping: toppings) {
            System.out.print(" " + topping);
        }
        System.out.println();
    }
}

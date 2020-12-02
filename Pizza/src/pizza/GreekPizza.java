package pizza;

import pizza.ingredients.PizzaIngredientFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GreekPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public GreekPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        name = "Greek Pizza";
    }

    @Override
    public void prepare() {
        // creating NY Style Cheese Pizza at runtime
        // can be of any regions Greek Pizza based on the ingredient Factory passed
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
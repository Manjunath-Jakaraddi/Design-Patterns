import pizza.Pizza;

public abstract class PizzaStore {

    // in order to standardise the process making this class abstract and implementing
    // it will enable us to constraint the process throught inheritence
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}

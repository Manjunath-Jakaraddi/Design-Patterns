package beverage;

public abstract class Beverage {
    // already given by the starbuzz cannot modify this code
    // could've improved from abstract class to interface for
    // better implementation of decorator pattern
    String description = "Unknown beverage.Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

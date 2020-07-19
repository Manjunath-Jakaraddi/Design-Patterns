package condiments;

import beverage.Beverage;

public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double getSizedCost() {
        switch (getSize()) {
            case TALL: return 0.15;
            case VENTI: return 0.20;
            case GRANDE: return 0.25;
        }
        return 0;
    }

    @Override
    public double cost() {
        return getSizedCost() + beverage.cost();
    }
}

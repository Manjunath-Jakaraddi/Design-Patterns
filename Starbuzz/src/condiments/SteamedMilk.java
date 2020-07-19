package condiments;

import beverage.Beverage;

public class SteamedMilk extends CondimentDecorator {
    Beverage beverage;

    public SteamedMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Steamed Milk";
    }

    public double getSizedCost() {
        switch (getSize()) {
            case TALL: return 0.1;
            case VENTI: return 0.15;
            case GRANDE: return 0.2;
        }
        return 0;
    }

    @Override
    public double cost() {
        return getSizedCost() + beverage.cost();
    }
}

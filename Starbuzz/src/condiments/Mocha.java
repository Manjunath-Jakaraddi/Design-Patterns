package condiments;

import beverage.Beverage;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    public double getSizedCost() {
        switch (getSize()) {
            case TALL: return 0.2;
            case VENTI: return 0.25;
            case GRANDE: return 0.3;
        }
        return 0;
    }

    @Override
    public double cost() {
        return getSizedCost() + beverage.cost();
    }

}

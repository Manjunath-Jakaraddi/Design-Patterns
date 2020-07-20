import beverage.Beverage;
import beverage.DarkRoast;
import beverage.Espresso;
import beverage.HouseBlend;
import condiments.Mocha;
import condiments.Soy;
import condiments.Whip;

public class Application {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();

        //TALL Espresso $ 1.99
        System.out.println(beverage.getDescription() + " $ " + beverage.cost());


        Beverage beverage1 = new DarkRoast();
        // should be on the concrete beverage class i.e the first one not on the following ones
        beverage1.setSize(Beverage.Size.GRANDE);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        beverage1 = new Whip(beverage1);

        // does not work
        // beverage1.setSize(Beverage.Size.GRANDE);

        //GRANDE Dark Roast Coffee, Mocha, Mocha, Whip $ 1.49
        System.out.println(beverage1.getDescription() +  " $ " + beverage1.cost());


        Beverage beverage2 =  new HouseBlend();
        beverage2.setSize(Beverage.Size.VENTI);
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);

        //VENTI House Blend Coffee, Soy, Mocha, Whip $ 1.34
        System.out.println(beverage2.getDescription() + " $ " + beverage2.cost());
    }
}

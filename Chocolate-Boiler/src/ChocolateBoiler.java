/**
 * The problem with the below class arises in multithreading
 * when two classes call the getInstance() method and get two instances
 * of the same class which was supposed to be singleton
 * the boiler state becomes inconsistent
 * Inorder to avoid we can follow 3 approaches
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler chocolateBoiler;

    private ChocolateBoiler() {}

    public static ChocolateBoiler getInstance() {
        if(chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }

    public void fill() {
        if(isEmpty()) {
            empty = false;
            boiled = false;
            // fill the boiler with milk/chocolate mixture
        }
    }

    public void boil() {
        if(!isEmpty() && !isBoiled()) {
            // boil the contents
            boiled = true;
        }
    }

    public void drain() {
        if(!isEmpty() && isBoiled()) {
            // empty the boiler
            empty = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
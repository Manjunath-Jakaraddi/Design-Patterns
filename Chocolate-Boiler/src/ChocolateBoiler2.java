/**
 * Move to an eagerly created instance rather than a lazily created one.
 * We can pre-create the instance before anyone requests it, but this approach
 * to be used only when the instance is not resource heavy and have high chances
 * that it might be requested, Well if we want to lazy load and also have the threads
 * synchronize we can use approach 3
 */
public class ChocolateBoiler2 {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler2 chocolateBoiler = new ChocolateBoiler2();

    private ChocolateBoiler2() {}

    public static ChocolateBoiler2 getInstance() {
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
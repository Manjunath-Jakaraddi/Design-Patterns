/**
 * If callign the constructor is not a performance bottle
 * neck we can make it synchronized so only one of the threads
 * can execute it at a given time, but what if it is heavily used
 * by multiple threads we don't want to the threads to wait on the
 * getInstance() method, so approach 2
 */
public class ChocolateBoiler1 {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler1 chocolateBoiler;

    private ChocolateBoiler1() {}

    public static synchronized ChocolateBoiler1 getInstance() {
        if(chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler1();
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
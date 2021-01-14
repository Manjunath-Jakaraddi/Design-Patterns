public class ChocolateBoiler3 {
    private boolean empty;
    private boolean boiled;

    // make variable volatile as it will be accessed inside the synchronized section
    private volatile static ChocolateBoiler3 chocolateBoiler = new ChocolateBoiler3();

    private ChocolateBoiler3() {}

    public static ChocolateBoiler3 getInstance() {
        if(chocolateBoiler == null) {
            // Can have 2 or more threads waiting here for the first time
            // synchronize and check again for null so for the 2 thread it wont create again
            synchronized (Singleton.class) {
                if (chocolateBoiler == null) {
                    chocolateBoiler = new ChocolateBoiler3();
                }
            }
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
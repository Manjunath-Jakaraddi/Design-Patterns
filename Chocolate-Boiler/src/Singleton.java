public class Singleton {
    // single object reference
    private static Singleton uniqueInstance;

    // private because no object can be created outside this class
    private Singleton() {}

    public static Singleton getInstance() {
        if(uniqueInstance == null) {
            // first time object creation
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

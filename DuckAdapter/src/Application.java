public class Application {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyObjectAdapter(turkey);

        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("\nThe Duck says...");
        testDuck(duck);

        System.out.println("\nThe Duck says...");
        testDuck(turkeyAdapter);
    }

    private static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}

/**
 * The difference between decorators and adapter is the intent
 * adapter convert the interface and make it easier to consume for the client
 * whereas the decorater enables to add new behaviour and does change any interface(maintains the same interface)
 * Adapter -> Converts one interface to another
 * Decorator -> Doesn’t alter the interface, but adds responsibility
 * Facade -> Makes an interface simpler (when subsystem is very complex it exposes a simplified interface as per clients requirements)
 *          It also enables decoupling from subsystem if a new device is bought can be easily replaced in subsytem and still works the same
 */

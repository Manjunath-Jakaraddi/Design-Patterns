public class TurkeyObjectAdapter implements Duck {
    Turkey turkey; // object adapter used composition
    // can adapter more than one class as well
    // can create 2 way adapter as well

    public TurkeyObjectAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for(int i=0; i<5; i++) {
            turkey.fly();
        }
    }
}

/**
 * In case of class adapter, the adapter would inherit both turkey and duck
 * (possible with languages which support multiple inheritance) and the adapter
 * class would not have composed objects adv of class adapter code reuse but comes
 * at cost of not modifiable(flexible) and not extensible to support subclasses as well which is
 * possible in case of object adapter
 */

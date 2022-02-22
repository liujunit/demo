package design.bridge;

public abstract class Abstraction {

    private Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    public Implementor getImp() {
        return imp;
    }

    public void request() {
        this.imp.doSomething();
    }
}

package designPattern.proxyMode;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);
        subject.speak();
        subject.sellBook();
    }

}

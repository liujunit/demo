package designPattern.proxyMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Subject subject;

    public MyInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理");
        if (method.getName().equals("sellBook")) {
            int i = (int) method.invoke(subject, args);
            System.out.println("调用卖书");
            return i;
        } else {
            String s = (String) method.invoke(subject, args);
            System.out.println("调用说话");
            return s;
        }
    }

}

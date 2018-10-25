package jvm;

public class Main {

    private Object instance;

    public Main(){
//        byte[] b = new byte[20 * 1024 * 1024];
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Main m2 = new Main();
        m1.instance = m2;
        m2.instance = m2;
        System.gc();
    }

}

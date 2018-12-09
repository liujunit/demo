package classLoader;

public class ClassForName {

    /**
     * 静态块
     */
    static {
        System.out.println("静态块加载");
    }

    /**
     * 静态变量
     */
    private static String method = method();

    /**
     * 赋值静态变量的静态方法
     * @return
     */
    private static String method() {
        System.out.println("执行了静态方法");
        return "静态方法的返回";
    }

    public void methods() {

    }

}

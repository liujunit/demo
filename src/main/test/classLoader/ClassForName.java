package classLoader;

public class ClassForName {

    private static ClassForName cfn = null;

    /**
     * 静态块
     */
    static {
        cfn = new ClassForName();
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
        System.out.println("实例化对象：" + cfn);
        return "静态方法的返回";
    }

    public void methods() {

    }

}

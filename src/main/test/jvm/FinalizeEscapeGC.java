package jvm;

/**
 * @author liujun
 * finalize（）方法
 * 对象在GC回收前的最后一丝希望
 * 1.对象可以被GC时完成自我的拯救
 * 2.这种自救的机会只有一次，以为一个对象的finalize（）方法最多只会被系统调用一次
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("is live");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 执行");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();
        //第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalizer方法的优先等级低，暂停0.5秒可以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("is die");
        }

        //第二次会失败
        SAVE_HOOK = null;
        System.gc();
        //因为finalizer方法的优先等级低，暂停0.5秒可以等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("is die");
        }
    }
}

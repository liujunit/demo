package javase;

/**
 * 深拷贝：对象实体的复制外加属性的复制
 * 浅拷贝：只是对象的靠背，属性还是公用的对象
 */
public class CloneDemo implements Cloneable{

    private A a;

    @Override
    public String toString() {
        return "CloneDemo{" +
                "a=" + a +
                '}';
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    protected Object clone(){
        try {
            CloneDemo clone = (CloneDemo)super.clone();
            clone.setA((A) clone.getA().clone());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new Error("This should never happen");
        }
    }

    public static void main(String[] args){
        CloneDemo cloneDemo1 = new CloneDemo();
        cloneDemo1.setA(new A());
        CloneDemo cloneDemo2 = (CloneDemo)cloneDemo1.clone();
        System.out.println(cloneDemo1);
        System.out.println(cloneDemo2);
        System.out.println(cloneDemo1.getA());
        System.out.println(cloneDemo2.getA());
    }
}

class A implements Cloneable{
    @Override
    protected Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("This is never happen");
        }
    }
}

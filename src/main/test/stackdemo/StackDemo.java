package stackdemo;

import java.util.Stack;

/**
 * 栈 先进后出
 */
public class StackDemo {

    public static void showpush(Stack<Integer> stack, int a) {
        stack.push(a);
        System.out.println("push:" + a);
        System.out.println("stack:" + stack);
    }

    public static void showpop(Stack<Integer> stack) {
        System.out.println("pop->");
        Integer a = stack.pop();
        System.out.println("a(pop):" + a);
        System.out.println("stack" + stack);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("stack:" + stack);
        showpush(stack, 10);
        showpush(stack, 11);
        showpush(stack, 5);
        showpush(stack, 2);
        //查询元素的位置
        int search = stack.search(2);
        System.out.println(search);
        //查询栈顶的元素 但是不从栈顶移除
        Integer peek = stack.peek();
        System.out.println(peek);
        showpop(stack);
        showpop(stack);
    }

}

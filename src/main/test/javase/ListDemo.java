package javase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListDemo {

    public static void main(String[] args) {
        Set<String> setStr = new HashSet<>();
        setStr.add("a");
        setStr.add("b");
        ArrayList<String> listStr = new ArrayList<>(setStr);
        listStr.add("12");
        if (listStr == null || listStr.size() == 0) {
            listStr.add("0000000");
        }
        System.out.println(listStr);


    }

}

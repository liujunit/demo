package demo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    private static String a = "a";

    public static void main(String[] args) {
        System.out.println(a.hashCode());
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        String m = ",1,2,34,4,";
        m = m.substring(1, m.length() -1);
        System.out.println(m);
    }


}

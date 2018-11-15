package sort;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapSort {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("\\6113\\T01_0001.JPG","1");
        map.put("\\6113\\T01_0002.JPG","2");
        map.put("\\6113\\T01_0003.JPG","3");
        map.put("\\6113\\T01_0004.JPG","4");
        map.put("\\6113\\T01_0005.JPG","5");
        map.put("\\6113\\T01_0006.JPG","6");
        map.put("\\6113\\T01_0007.JPG","7");
        map.put("\\6113\\T01_0008.JPG","8");
        map.put("\\6113\\T01_0009.JPG","9");
        map.put("\\6113\\T01_0010.JPG","11");
        map.put("\\6113\\T01_0011.JPG","12");
        map.put("\\6113\\T01_0012.JPG","21");
        map.put("\\6113\\T01_0013.JPG","2");
        map.put("\\6113\\T01_0014.JPG","2");
        map.put("\\6113\\T01_0015.JPG","1");
        map.put("\\6113\\T01_0016.JPG","2");
        Map<String, String> sortMap = new TreeMap<>((a, b) -> {
            a = a.substring((a.lastIndexOf("\\\\")+1),a.indexOf("."));
            b = b.substring((b.lastIndexOf("\\\\")+1),b.indexOf("."));
            return a.compareTo(b);
        });
        sortMap.putAll(map);
        sortMap.forEach((a, b) -> System.out.println(a));
    }

}

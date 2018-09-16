package sort;

import java.util.*;

/**
 * 集合排序工具类
 */
public class CollectionSortUtil {

    /**
     * map根据key排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map){
        if (map == null || map.isEmpty()){
            return map;
        }
        Map<String, String> resultMap = new TreeMap<>((a, b) -> {
            //自定义排序规则
//            a = a.substring((a.lastIndexOf("\\")+1),a.indexOf("."));
//            b = b.substring((b.lastIndexOf("\\")+1),b.indexOf("."));
            int m = Integer.valueOf(a);
            int n = Integer.valueOf(b);
            return m - n;
        });
        resultMap.putAll(map);
        return resultMap;
    }


    /**
     * map根据value排序
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> map){
        if (map == null || map.isEmpty()){
            return map;
        }
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
                map.entrySet());
        Collections.sort(entryList, (a, b) ->{
            String m = a.getValue().substring((a.getValue().lastIndexOf(("\\\\"))+1), a.getValue().indexOf("."));
            String n = b.getValue().substring((b.getValue().lastIndexOf(("\\\\"))+1), b.getValue().indexOf("."));
            return m.compareTo(n);
        });
        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

}

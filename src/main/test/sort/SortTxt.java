package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SortTxt {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\MJCX.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        Map<String, String> map = new HashMap<>();
        while ((line = bufferedReader.readLine())!=null) {
            String[] split = line.split(",");
            map.put(split[0], line);
        }
        Map<String, String> resultMap = CollectionSortUtil.sortMapByKey(map);
        resultMap.forEach((a, b) ->{
            String[] split = b.split(",");
            if ("公开".equals(split[3])) {
                System.out.println(b);
            }
        });
//        FileReader fr = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\地质资料目录.txt");
//        BufferedReader bf = new BufferedReader(fr);
//        String l = "";
//        while ((l = bf.readLine())!=null) {
//            String s = map.get(l.trim());
//            if (!"".equals(s)){
//                String[] split = s.split(",");
//                if (!"公开".equals(split[3])){
//                    System.out.println(s);
//                }else {
//                    System.out.println(split[0]);
//                }
//            }
//        }
    }

}

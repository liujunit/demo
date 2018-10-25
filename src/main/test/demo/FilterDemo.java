package demo;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilterDemo {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\MJCX.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Map<String, String> map = new HashMap<>();
        while ((line = br.readLine())!=null) {
            String[] split = line.split(",");
            map.put(split[0], line);
        }

        FileReader fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\查找秘密数据.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String l = "";
        String[] reg = {"放射性元素","水文","铀矿","重力","航磁","钋","氡","钫","镭","锕","钍","镤","铀","机密"};
        while ((l = bf.readLine()) != null) {
            String str = l.replaceAll("\t","").trim();
            boolean flag = StringUtils.containsAny(str, reg);
            if (!flag) {
                String[] split = l.split("\t");
                if (map.containsKey(split[0])){
                    String s = map.get(split[0]);
                    if (!s.contains("机密")){
                        System.out.println(split[0] + "\t" + split[1] + "\t" + s.split(",")[3]);
                    }
                }else {
                    System.out.println(split[0] + "\t" + split[1]);
                }
            }
        }
    }

}

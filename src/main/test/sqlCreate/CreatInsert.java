package sqlCreate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jiuyuan4 on 2018/8/3.
 */
public class CreatInsert {

    public static void main(String[] args) throws IOException {
        // Java8用流的方式读文件，更加高效
//        Files.lines(Paths.get("C:\\Users\\jiuyuan4\\Desktop\\西安\\新建文本文档.txt"), StandardCharsets.UTF_8)
//                .forEach(a -> System.out.println("INSERT INTO test VALUES('" + a + "','','','','');"));

//        Files.lines(Paths.get("C:\\Users\\jiuyuan4\\Desktop\\西安\\数据.txt"), StandardCharsets.UTF_8)
//                .forEach(a -> System.out.println(a));
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jiuyuan4\\Desktop\\西安\\数据.txt"));
        String line = "";
        while ((line = br.readLine())!=null){
            if (!"null".equals(line)){
                String yearS = fomatDateString(line).substring(0,4);
                int year = Integer.valueOf(yearS);
                if (year <= 1959){
                    System.out.println(50);//60年代之前
                }else if (year >= 1960 && year <= 1969){
                    System.out.println(60);
                }else if (year >= 1970 && year <= 1979){
                    System.out.println(70);
                }else if (year >= 1980 && year <= 1989){
                    System.out.println(80);
                }else if (year >= 1990 && year <= 1999){
                    System.out.println(90);
                }else if (year >= 2000){
                    System.out.println(2000);
                }
            }else{
                System.out.println(1);
            }
        }
        br.close();
    }

    /**
     * 格林威治时间
     * 格式化
     * @return
     */
    public static String fomatDateString(String value) {
        DateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat ctsTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
        SimpleDateFormat cdtTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CDT' yyyy", Locale.US);
        Date d = null;
        try {
            if (value.indexOf("CST")>0){
                d = ctsTime.parse(value);
            }else {
                d = cdtTime.parse(value);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String time = fmt.format(d);
        return time;
    }

}

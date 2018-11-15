package demo;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeDemo {

    public static void main(String[] args) throws ParseException, IOException {
        FileReader fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\time.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            DateFormat fmt1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'CST' yyyy", Locale.US);
            DateFormat fmt2 = new SimpleDateFormat("yyyy年MM月dd日");
            Date parse = fmt2.parse(line);
            String format = fmt1.format(parse);
            System.out.println(format);

        }
    }

}

package sqlCreate;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZtcSplit {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\ztc.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        Set<String> set = new HashSet<>();
        String line = "";
        while ((line = bf.readLine()) != null) {
            if (!"".equals(line)) {
                String[] split = line.replaceAll("\\s+|、", ",").replaceAll("。", "").split(",");
                Arrays.stream(split).forEach(m -> {
                    if (!"".equals(m)){
                        if (!set.contains(m)) {
                            set.add(m);
                        }
                    }
                });
            }
        }
        FileWriter fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\dm.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        set.stream().forEach(a -> {
            try {
                bufferedWriter.write(a);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
        fileWriter.close();
        bf.close();
        fileReader.close();
    }

    @Test
    public void isSpaceName() throws IOException {
        FileReader fr = new FileReader("E:\\西安\\琦哥给的包\\data.txt");
        BufferedReader bf = new BufferedReader(fr);
        Set<String> set = new HashSet<>();
        String line = "";
        while ((line = bf.readLine()) != null) {
            line = line.replaceAll("[^\u4E00-\u9FA5]", "");
            if (!set.contains(line)) {
                set.add(line);
            }
        }

        FileReader fr2 = new FileReader("C:\\Users\\Administrator\\Desktop\\dm.txt");
        BufferedReader bf2 = new BufferedReader(fr2);
        Set<String> set2 = new HashSet<>();
        String line2 = "";
        while ((line2 = bf2.readLine()) != null) {
            if (line2.length() >= 2) {
                if (set.contains(line2)) {
                    set2.add(line2);
                }
            }
        }


        FileWriter fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\dm2.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        set2.stream().forEach(a -> {
            try {
                System.out.println(a);
                bufferedWriter.write(a);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bufferedWriter.close();
        fileWriter.close();
    }


    @Test
    public void insertData() throws IOException {
        FileReader fileReader = new FileReader("E:\\西安\\目录数据dbf\\地名词.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        Set<String> set = new HashSet<>();
        String line = "";
        while ((line = bf.readLine()) != null) {
            set.add(line);
        }

        FileReader fr2 = new FileReader("C:\\Users\\Administrator\\Desktop\\dm2.txt");
        BufferedReader bf2 = new BufferedReader(fr2);
        String line2 = "";
        int num = 38683;
        while ((line2 = bf2.readLine()) != null) {
            if (!set.contains(line2)) {
                System.out.println("INSERT INTO PLACE_NAME (ID, PLACE_NAME) VALUES ('" + num + "', '"+ line2 +"');");
                num ++;
            }
        }

    }

}

package sqlCreate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextCreate {

    public static void main(String[]  args) {
        FileReader fileReader = null;
        FileReader fileReader2 = null;
        FileWriter fileWriter = null;
        Map<String, String> map = new HashMap<>();
        try {
            fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\DIRECTORY_DATA.txt");
            fileReader2 = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\t2.txt");
            fileWriter = new FileWriter("C:\\Users\\jiuyuan4\\Desktop\\t1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split("\t");
                String key = "";
                String value = "";
                for (int i = 0; i < split.length; i++) {
                    if (i==0)
                        key = split[i].replaceAll("\"", "");
                    if (i==10)
                        value = split[i].replaceAll("\"", "");
                }
                map.put(key, value);
            }
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String line2 = "";
            while ((line2 = bufferedReader2.readLine()) != null){
                System.out.println(line2 + ":" + map.get(line2));
                bufferedWriter.write(map.get(line2) + "");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                fileReader2.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

package fileOperation;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 文本去重
 * 源文件->去重后的文件
 */
public class TextDuplication {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        Set<String> set = new HashSet<>();
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("H:\\地名.txt");
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                set.add(line);
            }
            System.out.println(set.size());
            File file = new File("H:\\新地名.txt");
            file.createNewFile();
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (String s : set) {
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

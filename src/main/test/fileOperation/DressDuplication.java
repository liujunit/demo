package fileOperation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 一个文件根据另一个文件去重
 */
public class DressDuplication {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        List<String> addrList = new ArrayList<>();
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fr = new FileReader("H:\\新地名.txt");
            br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split("\t");
                addrList.add(lineArray[0]);
            }
            fr1 = new FileReader("H:\\default.dic");
            br1 = new BufferedReader(fr1);
            File file = new File("H:\\default1.dic");
            file.createNewFile();
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            String line1 = "";
            int count = 1;
            while ((line1 = br1.readLine()) != null) {
                String[] lineArray = line1.split("\t");
                //不包含的话重新生成新的文件
                if (!addrList.contains(lineArray[0])) {
                    bw.write(line1);
                    bw.newLine();
                    bw.flush();
                    System.out.println("执行：" + count);
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
                br1.close();
                fr1.close();
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

package fileParse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("测试生成文件");
        list.add("你好");
        File file = new File("D:\\1.txt");
        FileWriter fw = null;
        BufferedWriter bf = null;
        try {
            fw = new FileWriter(file);
            bf = new BufferedWriter(fw);
            for (int i = 0; i < list.size(); i++) {
                bf.write(list.get(i));
                bf.newLine();
                bf.flush();
            }
            System.out.println(file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

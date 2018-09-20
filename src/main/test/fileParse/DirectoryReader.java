package fileParse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DirectoryReader {

    public static void main(String[] args) throws IOException {

        File file = new File("E:\\档案库");
        FileWriter fileWriter = new FileWriter("E:\\档案号.txt");
        BufferedWriter bf = new BufferedWriter(fileWriter);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                bf.write(f.getName());
                bf.newLine();
                bf.flush();
                System.out.println("写入：" + f.getName());
            }
        }

    }

}

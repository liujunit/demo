package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CreateDirDemo {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\time.txt");
        String path = "C:\\Users\\jiuyuan4\\Desktop\\西安\\测试数据\\";
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            String numDir = path + line + "\\存档电子文件";
            File dirFile = new File(numDir);
            dirFile.mkdirs();
            File file = new File(numDir + "\\电子文件登记表.meta");
            if (!file.exists()){
                file.createNewFile();
                System.out.println("创建文件：" + numDir + "\\电子文件登记表.meta");
            }
        }
    }

}

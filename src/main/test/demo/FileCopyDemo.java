package demo;

import java.io.*;

public class FileCopyDemo {


    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\西安\\数据备份\\地址资料文件档号.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            String sourcePath = "E:\\西安\\提取完成后的文件\\提取\\" + line;
            String newPath = "E:\\西安\\本地所需的提取文件\\" + line;
            copyDir(sourcePath, newPath);
        }
    }


    public static void copyDir(String sourcePath, String newPath) throws IOException {
        System.out.println("开始复制数据：" + sourcePath);
        File file = new File(sourcePath);
        if (!file.exists()){
//            FileWriter fileWriter = new FileWriter("E:\\1.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(sourcePath);
//            bufferedWriter.newLine();
            System.out.println("此文档不存在" + sourcePath);
            return;
        }
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath  + file.separator  + filePath[i], newPath  + file.separator + filePath[i]);
            }

            if (new File(sourcePath  + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    public static void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        //只复制.meta文件
        if (oldFile.getName().endsWith(".meta")) {
            File file = new File(newPath);
            FileInputStream in = new FileInputStream(oldFile);
            FileOutputStream out = new FileOutputStream(file);
//            byte[] buffer=new byte[2097152];
            byte[] buffer=new byte[in.available()];
            while((in.read(buffer)) != -1){
                out.write(buffer);
            }
            out.flush();
            out.close();
            System.out.println("数据复制完成：" + newPath);
        }
    }

}

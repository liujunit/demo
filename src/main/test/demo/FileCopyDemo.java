package demo;

import java.io.*;

public class FileCopyDemo {


    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("F:\\3.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            String sourcePath = "F:\\sxGeologicw\\" + line;
            String newPath = "F:\\带走\\" + line;
            copyDir(sourcePath, newPath);
        }
    }


    public static void copyDir(String sourcePath, String newPath) throws IOException {
        System.out.println("开始复制数据：" + sourcePath);
        File file = new File(sourcePath);
        if (!file.exists()){
            FileWriter fileWriter = new FileWriter("F:\\1.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(sourcePath);
            bufferedWriter.newLine();
            bufferedWriter.close();
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
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);
        byte[] buffer=new byte[2097152];
        while((in.read(buffer)) != -1){
            out.write(buffer);
        }
        System.out.println("数据复制完成：" + newPath);
    }



}

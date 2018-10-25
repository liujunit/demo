package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirDemo {

    public static void main(String[] args) {
        //取得目标目录
        File file = new File("G:\\dzl\\1");
        String resultPath = "G:\\提取";
        //获取目录下子文件及子文件夹
        File[] files = file.listFiles();
        readfile(files, resultPath);
    }

    public static void readfile(File[] files, String resultPath) {
        if (files == null) {// 如果目录为空，直接退出
            return;
        }
        Pattern pattern = Pattern.compile("[0-9]{4}\\S+");
        for(File f:files) {
            //如果是文件，直接输出名字
            if(f.isFile()) {
                String fileName = f.getName();
                if (fileName.contains("."))
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
                if ("电子文件登记表".equals(fileName)){
                    String path = f.getAbsolutePath();
                    Matcher matcher = pattern.matcher(path);
                    if (matcher.find()){
                        String relPath = resultPath+ "\\" + matcher.group(0);
                        fileCopy_channel(path, relPath);
                    }
                }
            }
            //如果是文件夹，递归调用
            else if(f.isDirectory()) {
                readfile(f.listFiles(), resultPath);
            }
        }
    }
    public static void fileCopy_channel(String inputS, String outputS) {
        System.out.println("复制文件：" + inputS);
        File dir = new File(outputS.substring(0, outputS.lastIndexOf("\\")));
        dir.mkdirs();
        FileChannel input = null;
        FileChannel output = null;
        try {
            input = new FileInputStream(inputS).getChannel();
            output = new FileOutputStream(outputS).getChannel();
            output.transferFrom(input, 0, input.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("复制完成：" + outputS);
    }
}

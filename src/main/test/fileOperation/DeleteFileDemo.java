package fileOperation;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author liujun
 * 文件删除Demo
 */
public class DeleteFileDemo {


    public static void main(String[] args) {
        File file = new File("E:\\测试数据大批量");
        deleteFiles(file);
    }

    public static void deleteFiles(File file) {
        File[] files = file.listFiles();
        List<File> fileList = Arrays.asList(files);
        fileList.forEach(f -> {
            String fName = f.getName();
            String fPath = f.getAbsolutePath();
            if ("thumbs".equals(fName) && f.isDirectory()) {
                File[] fArray = f.listFiles();
                //先删除文件
                Arrays.asList(fArray).forEach(thumbs -> {
                    if (thumbs.isFile()) {
                        thumbs.delete();
                        System.out.println("删除文件：" + thumbs.getAbsolutePath());
                    } else if (thumbs.isDirectory()) {
                        deleteFiles(thumbs);
                    }
                });
                //再删除文件夹
                f.delete();
                System.out.println("删除文件夹：" + fPath);
            } else if (f.isDirectory()) {
                deleteFiles(f);
            }
        });
    }

}

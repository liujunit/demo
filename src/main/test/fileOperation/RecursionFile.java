package fileOperation;

import java.io.File;

/**
 * 递归文件操作
 */
public class RecursionFile {


    public static void getZFilePath(String filePath) {
        File f1 = new File(filePath);
        String f1Name = f1.getName();
        if (f1.isDirectory()) {
            if ("存档电子文件".equals(f1Name)){
                File[] files = f1.listFiles();
                for (File file : files) {
                    String fileName = file.getName().toLowerCase();
                    if ("z01_0001.pdf".equals(fileName)) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            } else {
                File[] files = f1.listFiles();
                for (File file : files) {
                    if (file.isDirectory()) {
                        getZFilePath(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("E:\\西安\\测试2\\6001\\存档电子文件\\Z01_0001.pdf");
        String parent = new File(file.getParent()).getParent();
        String substring = parent.substring(parent.lastIndexOf("\\") + 1);
        System.out.println(substring);
    }


}

package fileParse;

import java.io.File;

public class ReNameFile {


    public static void main(String[] args) {
        File files = new File("G:\\geology");
        File[] files1 = files.listFiles();
        //获取档号目录
        for (int i = 0; i < files1.length; i++) {
            File file = files1[i];
            if (file.isDirectory()) {
                //每个档号下文件夹的遍历
                File[] files2 = file.listFiles();
                for (int i1 = 0; i1 < files2.length; i1++) {
                    //获取档号下的目录
                    if (files2[i1].isDirectory()) {
                        String thumbs = files2[i1].getName();
                        if ("thumbs".equals(thumbs)) {
                            File[] files3 = files2[i1].listFiles();
                            for (int i2 = 0; i2 < files3.length; i2++) {
                                String reName = "gtzyt.shaanxi.gov.cn@" + files3[i2].getName().substring(files3[i2].getName().indexOf(file.getName()));
                                String path = files3[i2].getPath();
                                reName = path.substring(0, path.lastIndexOf("\\") + 1) + reName;
                                files3[i2].renameTo(new File(reName));
                                System.out.println("更新" + reName);
                            }
                        }
                    }
                }
            }
        }


    }


}

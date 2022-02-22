package pdf;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.*;

/**
 * @Description:
 * @Author:         hs
 * @CreateDate:    2020/11/17
 * @UpdateUser:
 * @UpdateDate:
 * @UpdateRemark:
 * @Version:        1.0
 */
public class THCompressorUtil {

    // 全局.zip文件：zipFile
    private File zipFile;

    // 构造：初始化zipFile
    public THCompressorUtil(String pathName) {

        zipFile = new File(pathName);

    }


    /**
     * 压缩方法：多文件夹OR文件地址，将其打包道同一个.zip包中
     * @param pathName : String...
     */
    public void compress(String... pathName) {
        ZipOutputStream out = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zipFile);
            CheckedOutputStream cos = new CheckedOutputStream(fileOutputStream, new CRC32());
            out = new ZipOutputStream(cos);
            // 基础目录
            String basedir = "";
            for (int i = 0; i < pathName.length; i++) {
                execCompress(new File(pathName[i]), out, basedir);
            }
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行压缩
     * @param file
     * @param out
     * @param basedir
     */
    private void execCompress(File file, ZipOutputStream out, String basedir) {
        if (file.isDirectory()) {
            this.compressDirectory(file, out, basedir);
        } else {
            this.compressFile(file, out, basedir);
        }
    }

    /**
     * 压缩目录
     * @param dir
     * @param out
     * @param basedir
     */
    private void compressDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        Arrays.stream(files).forEach(file -> {
            // 递归调用: 扫描到当前目录下所有文件和字文件夹
            execCompress(file, out, basedir + dir.getName() + File.separator);
        });
    }

    /**
     * 压缩文件
     * @param file
     * @param out
     * @param basedir
     */
    private void compressFile(File file, ZipOutputStream out, String basedir) {
        // 合法性校验
        if (!file.exists()) {
            return;
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            ZipEntry entry = new ZipEntry(basedir + file.getName());
            out.putNextEntry(entry);
            int count;
            byte data[] = new byte[1024];
            while ((count = bis.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);
            }
            bis.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解压缩功能，类似与压缩工具中的解压到当前文件夹
     * @param file 被解压的zip文件
     */
    public static void unCompress(File file) {
        if(!file.exists()) {
            throw new RuntimeException("解压缩路径文件不存在：" + file.getAbsolutePath());
        }
        try {
            FileInputStream in = new FileInputStream(file);
            CheckedInputStream check = new CheckedInputStream(in, new CRC32());
            ZipInputStream read = new ZipInputStream(check);
            unCompress(read, file.getParent() );
            read.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 路径创建
     * @param read
     * @param path
     * @throws Exception
     */
    private static void unCompress(ZipInputStream read, String path) throws Exception{
        ZipEntry entry = null;
        while(null != (entry = read.getNextEntry())) {
            String name = entry.getName();
            File file = new File(path + "/" + name);
            //创建目录
            file.getParentFile().mkdirs();
            unCompressFile(read, file);
            read.closeEntry();
        }
    }

    /**
     * 解压文件
     * @param read
     * @param file
     */
    private static void unCompressFile(ZipInputStream read, File file) {
        try{
            BufferedOutputStream write = new BufferedOutputStream(new FileOutputStream(file));
            int count;
            byte data[] = new byte[1024];
            while ((count = read.read(data, 0, 1024)) != -1) {
                write.write(data, 0, count);
            }
            write.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 调用方式
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("F:\\学习\\Netty");
        FileOutputStream fos = new FileOutputStream(new File("F:\\学习\\netty.zip"));
        ZipOutputStream out = new ZipOutputStream(fos);
        new THCompressorUtil("").compressDirectory(dir, out, "");



//        //调用压缩方法
//        new THCompressorUtil("").compress("D:/f1.css","D:/f2.html");
//        new THCompressorUtil("").compress(new String[] {"A", "B"});
//        List<String> list = new ArrayList<>();
//        new THCompressorUtil("").compress((String[]) list.toArray());
//
//        // Fies => 校验 ： 是否存在，已存在（跳过），未存在，生成
//
//        //调用解压
//        THCompressorUtil.unCompress(new File("F:\\Demo\\swiper.zip"));
    }

}

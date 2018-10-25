package image;

import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageEncoder;
import com.sun.media.jai.codec.TIFFEncodeParam;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.io.*;

/**
 * 所有jpg转tif
 */
public class ToTiff {

    public static void main(String[] args) {
        String path = "F:\\西安\\测试数据";
        getAllJPG(path);
    }

    public static void getAllJPG(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getAllJPG(f.getAbsolutePath());
            }else {
                String fileName = f.getName();
                if (fileName.contains(".")){
                    String[] split = fileName.split("\\.");
                    if ("JPG".equals(split[1]) || "jpg".equals(split[1])){
                        jpg2Tif(f.getAbsolutePath());
                    }
                }
            }
        }
    }


    public static void jpg2Tif(String fileAbsolutePath) {
        System.out.println("转换" + fileAbsolutePath);
        OutputStream outputStream = null;
        try {
            RenderedOp renderOp = JAI.create("fileload", fileAbsolutePath);
            String tifFilePath = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."))+".tif";
            outputStream = new FileOutputStream(tifFilePath);
            TIFFEncodeParam tiffParam = new TIFFEncodeParam();
            ImageEncoder imageEncoder = ImageCodec.createImageEncoder("TIFF", outputStream, tiffParam);
            imageEncoder.encode(renderOp);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
                outputStream = null;
            }
        }
        System.out.println("转换成功");
    }
}

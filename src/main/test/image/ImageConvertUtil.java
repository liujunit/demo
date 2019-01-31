package image;

import com.sun.media.jai.codec.*;

import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.ParameterBlock;
import java.io.*;

public class ImageConvertUtil {

    public static void tif2Jpg(String fileAbsolutePath) {
        if (fileAbsolutePath == null || "".equals(fileAbsolutePath.trim())){
            return ;
        }
        if (!new File(fileAbsolutePath).exists()){
            return ;
        }
        FileSeekableStream fileSeekStream = null;
        try {
            fileSeekStream = new FileSeekableStream(fileAbsolutePath);
            TIFFEncodeParam tiffEncodeParam = new TIFFEncodeParam();
            JPEGEncodeParam jpegEncodeParam = new JPEGEncodeParam();
            ImageDecoder dec = ImageCodec.createImageDecoder("tiff", fileSeekStream, null);
            int count = dec.getNumPages();
            tiffEncodeParam.setCompression(TIFFEncodeParam.COMPRESSION_GROUP4);
            tiffEncodeParam.setLittleEndian(false);
            String filePathPrefix = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("."));
            for (int i = 0; i < count; i++) {
                RenderedImage renderedImage = dec.decodeAsRenderedImage(i);
                File imgFile = new File(filePathPrefix + "_" + i + ".jpg");
                ParameterBlock pb = new ParameterBlock();
                pb.addSource(renderedImage);
                pb.add(imgFile.toString());
                pb.add("JPEG");
                pb.add(jpegEncodeParam);
                RenderedOp renderedOp = JAI.create("filestore",pb);
                renderedOp.dispose();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (fileSeekStream != null){
                try {
                    fileSeekStream.close();
                } catch (IOException e) {
                }
                fileSeekStream = null;
            }
        }
    }

    public static void jpg2Tif(String fileAbsolutePath) {
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
    }

    public static void main(String[] args) {
        String filePath = "F:\\imageSource\\3244\\t01_0004.tif";
        tif2Jpg(filePath);
    }

}

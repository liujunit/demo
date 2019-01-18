package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ImageUtil {

    private static String DEFAULT_PREVFIX = "thumb_";

    private static boolean DEFAULT_FORCE = false;

    public static void thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force) {

        File imageFile = new File(imagePath);
        if(imageFile.exists()) {
            //查询ImageIO支持的处理图片的类型
            String types = Arrays.toString(ImageIO.getReaderFormatNames());
            String suffix = null;
            //获取图片的后缀
            if (imageFile.getName().indexOf(".") > -1) {
                suffix = imageFile.getName().substring(imageFile.getName().lastIndexOf(".") + 1);
            }
            //判断图片类型是被支持处理
            if (suffix == null || types.toLowerCase().indexOf(suffix.toLowerCase()) < 0) {
                System.out.println("不支持此类型图片的处理：" + suffix);
                return;
            }
            try {
                Image img = ImageIO.read(imageFile);
                //通过原图与要求的宽高生成合适的缩略比例
                if (!force) {
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new DecimalFormat("0").format(height * w/(width*1.0)));
                        }
                    } else {
                        if(height > h) {
                            w = Integer.parseInt(new DecimalFormat("0").format(width * h/(height*1.0)));
                        }
                    }
                    BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                    Graphics g = bi.getGraphics();
                    g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                    g.dispose();
                    String p = imageFile.getPath();
                    ImageIO.write(bi, suffix, new File(p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix + imageFile.getName()));
                    System.out.println("缩略图生成成功：" + p);
                }
            } catch (IOException e) {
                System.out.println("缩略图生成失败" + e.getMessage());
            }
        } else {
            System.out.println("原图不存在");
        }
    }

    public static void main(String[] args) {
        thumbnailImage("E:\\处理\\8019\\存档电子文件\\T02_0001.JPG", 250, 250, DEFAULT_PREVFIX, DEFAULT_FORCE);
    }

}

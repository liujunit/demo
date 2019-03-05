package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ImageIO测试类
 */
public class ImageIOTest {

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "1");
        System.out.println(map.get("2"));


    }

}

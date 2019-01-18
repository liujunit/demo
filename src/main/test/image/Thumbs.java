package image;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class Thumbs {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\处理\\8019\\thumbs\\T02_0001.JPG");
        file.createNewFile();
        Thumbnails.of("E:\\处理\\8019\\存档电子文件\\T02_0001.JPG")
                .scale(0.25f)
                .outputQuality(0.5f)
                .toFile(file);
        System.out.println("完成");
    }

}

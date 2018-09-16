package demo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateFileDemo {

    /**
     * 读文件创建文件夹
     */
    @Test
    public void createDir(){

        String readerPath = "C:\\Users\\jiuyuan4\\Desktop\\t.txt";
        String makePath = "C:\\Users\\jiuyuan4\\Desktop\\数据\\";
        try {
            List<String> list = Files
                    .lines(Paths.get(readerPath), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());
            list.forEach(a -> {
                File file = new File(makePath + a);
                if (!file.exists()) file.mkdir();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

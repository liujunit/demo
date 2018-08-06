package sqlCreate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by jiuyuan4 on 2018/8/3.
 */
public class CreatInsert {

    public static void main(String[] args) throws IOException {
        // Java8用流的方式读文件，更加高效
//        Files.lines(Paths.get("C:\\Users\\jiuyuan4\\Desktop\\西安\\新建文本文档.txt"), StandardCharsets.UTF_8)
//                .forEach(a -> System.out.println("INSERT INTO test VALUES('" + a + "','','','','');"));

        Files.lines(Paths.get("C:\\Users\\jiuyuan4\\Desktop\\西安\\新建文本文档.txt"), StandardCharsets.UTF_8)
                .forEach(a -> System.out.println("'" + a + "', " ));

    }

}

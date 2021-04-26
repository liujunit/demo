package yum;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

public class YumTest {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k3", "v2");
//        yaml.dump(map, new OutputStreamWriter(new FileOutputStream("02.yaml")));
        yaml.dump(map, new PrintWriter(new FileOutputStream("02.yaml")));
    }

}

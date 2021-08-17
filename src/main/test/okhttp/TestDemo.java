package okhttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {

    public static String PATTERN_L2DOMAIN = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?";
    public static String PATTERN_IP = "((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}";

    public static void main(String[] args) {
//        String a = "[\"eee.rr.rr\", \"dd.ddgf.ff\"]";
//        JSONArray objects = JSON.parseArray(a);
//        List<String> list = objects.toJavaList(String.class);
//        String join = StringUtils.join(list, ",");
//        System.out.println(join);

        String a = "   vv v ";
        String b = "bb ";
        System.out.println(a);
        System.out.println(b.trim());
    }

}

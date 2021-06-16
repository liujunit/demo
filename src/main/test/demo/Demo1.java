package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

//snort 规则
public class Demo1 {

    public static void main(String[] args) {
//        String reg = "^\\([[S+:\"S+\";]+]+\\)$";
//        String rule = "(msg:\"ET ATTACK_RESPONSE Cisco TclShell TFTP Download\"; content:\"|54 63 6C 53 68 65 6C 6C|\"; sid:2009245;)";

        String reg = "\\(((\\w+:((\\s)?(\".+\")|(\\d+));)(\\s)?)+\\)";
//        String rule = "content:\"ET ATTACK_RESPONSE Cisco TclShell TFTP Download\";";
        String rule = "(msg:\"ET ATTACK_RESPONSE Cisco TclShell TFTP Download\"; content: \"|54 63 6C 53 68 65 6C 6C|\"; sid:2009245;)";
        boolean isMatch = Pattern.matches(reg, rule);
        System.out.println(isMatch);


//        String reg2 = "([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5])";
//        String rule2 = "-2213";
//        System.out.println(Pattern.matches(reg2, rule2));
//
//        System.out.println(rule2.lastIndexOf("c"));

        String a = "(a:\"b\")";
        System.out.println(a);
        System.out.println(a.replaceAll("\"", "\\\\\""));
        System.out.println("\\\\\"");

    }

}

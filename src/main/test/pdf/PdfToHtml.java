package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiuyuan4 on 2018/7/10.
 */
public class PdfToHtml {

    /**
     * 正文的pdf解析
     * @param file
     * @return
     */
    public static StringBuffer toHtmlString(File file) throws IOException {
        PDDocument doc= PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper() {
            protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < textPositions.size(); i++) {
                    TextPosition textPosition = textPositions.get(i);
                    //获取字体大小
                    int fontSizeInPt = Math.round(textPosition.getFontSizeInPt()*1.5f);
                    //获取字体宽高
                    int fontWidth = Math.round(textPosition.getWidth());
                    int fontHeight = Math.round(textPosition.getHeight());
                    //计算缩进
                    int indent = Math.round(textPosition.getX());
                    //获取字体
                    PDFont font = textPosition.getFont();
                    String fontType = font.getName().substring(font.getName().indexOf("+")+1);
                    //Unicode码
                    String content = textPosition.getUnicode();
                    content = content.replaceAll("\\s+| ","&nbsp;");
                    if (textPositions.size()==1){
//                        builder.append(content);
//                    }else if (textPositions.size()==1){
                        builder.append("<font height=\""+ fontHeight +"\" width=\""+ fontWidth +"\" style=\"font-family:"+ fontType +"; font-size:" + fontSizeInPt + "px; padding-left:" + indent + "px; \">" + content + "</font>");
                    }else {
                        if (i==0){
                            builder.append("<font height=\""+ fontHeight +"\" width=\""+ fontWidth +"\" style=\"font-family:"+ fontType +"; font-size:" + fontSizeInPt + "px; padding-left:" + indent + "px; \">" + content);
                        }else if (i==(textPositions.size()-1)){
                            builder.append(content+"</font>");
                        }else {
                            builder.append(content);
                        }
                    }
                }
                writeString(builder.toString());
            }
        };
        StringBuffer stringBuffer = new StringBuffer();
        String content = stripper.getText(doc);
        //先获取文字
        String pdfLinesWithFont[]= content.split("\\r?\\n");
//        String fontType = "";
        int fontSizeItem = 0;
        int leftItem = 0;
        for (int i = 0; i < pdfLinesWithFont.length; i++) {
            String s = pdfLinesWithFont[i];
//            System.out.println("<p>" + s + "</p>");
            if (s.indexOf("</font>")!=s.lastIndexOf("</font>")){
                //font结束标签第一次出现的位置
                int i1 = s.indexOf("</font>");
                //计算第二次出现的位置
                int i2 = s.indexOf("</font>", i1 + 1);
                String s1 = s.substring(0,i1);
                String s2 = s.substring(i1,i2);
                Map<String, String> s1Match = match(s1);
                Map<String, String> s2Match = match(s2);
                int s1Size = Integer.parseInt(s1Match.get("font-size").replace("px", ""));
                int s2Size = Integer.parseInt(s2Match.get("font-size").replace("px", ""));
                //取同一行字中的最小值 只比较第一次和第二次
                int min = Math.min(s1Size, s2Size);
                //去掉每一行多余的font标签
                s = s.replaceAll("</font>\\s+<font .*?>", "").replaceAll("font-size:\\d+","font-size:"+min);
            }
            //获取font标签中的字码大小和左边距
            Map<String, String> fontInfo = match(s);
//            String font_type = fontInfo.get("font-family");
            int font_size = Integer.parseInt(fontInfo.get("font-size").replace("px",""));
            int font_left = Integer.parseInt(fontInfo.get("padding-left").replace("px",""));
            //逻辑判断是否是一个段落里面的 是的话去掉font标签
            if (font_size==fontSizeItem){//大小相同（先不进行字体的判断）
                //判断是否进行了缩进
                int left = leftItem - font_left;
                if (left>20 && left<35){ //大于20小于35判断为缩进 (这里会有一些问题！！！)
                    s = s.replaceAll("<font .*?>","").replaceAll("</font>","");
                    //这里去除上一行的结尾标签
                    String up = pdfLinesWithFont[i-1];
                    if (up.endsWith("</font></p>")){
                        pdfLinesWithFont[i-1] = up.substring(0,up.lastIndexOf("</font>"));
                    }
                }else {
                    leftItem = font_left;
                    if (i!=0 && !pdfLinesWithFont[i-1].contains("</font></p>") && !"<p></p>".equals(pdfLinesWithFont[i-1])){
                        pdfLinesWithFont[i-1] = pdfLinesWithFont[i-1] + "</font></p>";
                    }
                    s = "<p>" + s + "</p>";
                }
            }else {
//                fontType = font_type;
                fontSizeItem = font_size;
                leftItem = font_left;
                if (i!=0 && !pdfLinesWithFont[i-1].contains("</font></p>") && !"<p></p>".equals(pdfLinesWithFont[i-1])){
                    pdfLinesWithFont[i-1] = pdfLinesWithFont[i-1] + "</font></p>";
                }
                s = "<p>" + s + "</p>";
            }
            pdfLinesWithFont[i] = s;
        }
        pdfLinesWithFont[pdfLinesWithFont.length-1] = pdfLinesWithFont[pdfLinesWithFont.length-1] + "</font></p>";
        for (String s : pdfLinesWithFont) {
            if (s.endsWith("</font></p>")){
                s = s+"\n";
            }
            stringBuffer.append(s);
        }
        StringBuffer sb = new StringBuffer();
        String[] split = stringBuffer.toString().split("\\n");
        sb.append("<!DOCTYPE html>\n<html>\n<head></head>\n<body>\n");
        for (String s : split) {
            if (s.startsWith("<p><font")){
                int s1 = s.indexOf("\">")+2;
                int s2 = s.lastIndexOf("</font>");
                String m = s.substring(s1, s2).replaceAll("&nbsp;","").trim();
                boolean flag = true;
                if ("".equals(m) || m.matches("\\d+")) flag = false;
                if (flag) sb.append(s + "\n");
            }
        }
        sb.append("</body>\n<html>");
        doc.close();
        return sb;
    }

    /**
     * 获取style标签的属性值
     * @param source 要匹配的源文本
     * @return 属性值列表
     */
    protected static Map<String, String> match(String source) {
        Map<String, String> result = new HashMap<>();
        if ("".equals(source)){
            result.put("font-family","无");
            result.put("font-size","0px");
            result.put("padding-left","0px");
            return result;
        }
        String reg = "style=\".*\"";
        Pattern pattern = Pattern.compile(reg);
        Matcher m = pattern.matcher(source);
        while (m.find()) {
            String r = m.group(0);
            r = r.substring(r.indexOf("\"")+1,r.lastIndexOf("\""));
            String[] rSplit = r.split(";");
            for (String s : rSplit) {
                if (!"".equals(s.trim())){
                    String[] split = s.split(":");
                    result.put(split[0].trim(),split[1].trim());
                }
            }
        }
        return result;
    }

    /**
     * 解析电子文件登记表
     * 还是有一些不是准确的
     * @param file
     * @return
     */
    public static Map<String, String> locationToMap(File file) throws IOException {
        Map<String, String> map = new HashMap<>();
        PDDocument doc= PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(doc);
        String[] split = text.split("\\r?\\n");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split("\\s+");
            for (int j = 0; j < split1.length; j++) {
                if (split1[j].matches("[JSTZBQ]\\d{2}_\\d{4}") || split1[j].matches("[JSTZBQ]\\d{2}_\\d{4}.[a-zA-Z]+")){
                    String key = split1[j];
                    String value = split[i];
                    if (value.trim().endsWith(key)){
                        value = (split[i+1] + split[i+2] + split[i+3]).replaceAll("\\n","");
                    }else {
                        value = value + split[i+1] + split[i+2];
                    }
                    if (value.contains("[")){
                        value = value.replaceAll(key,"").replaceAll("\\d{1,2}-\\d{1,2}","").replaceAll("\\d{1,2}/\\d{1,2}\\s+[\\u4e00-\\u9fa5].*","").replaceAll("\\d+[KM]B","").replaceAll("[JSTZBQ]\\d{2}_\\d{4}.*","").trim().replaceAll(" ","").replaceAll("正文1|审批1","");
                    }else{
                        value = value.replaceAll(key,"").replaceAll("\\d{1,2}-\\d{1,2}","").replaceAll("\\d{1,2}/\\d{1,2}\\s+[\\u4e00-\\u9fa5].*","").replaceAll("\\d+[KM]B","").replaceAll("\\d{1,2}\\.\\d{1,2}.*","").trim().replaceAll(" ","").replaceAll("正文1|审批1","");
                    }
                    map.put(key,value);
                }
            }
        }
        return map;
    }



    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jiuyuan4\\Desktop\\资料\\存档电子文件\\Z01_0001.pdf");
        StringBuffer stringBuffer = toHtmlString(file);
        String[] split = stringBuffer.toString().split("\n");
        for (String s : split) {
            System.out.println(s);
        }
//        File file = new File("C:\\Users\\jiuyuan4\\Desktop\\资料\\存档电子文件\\3.pdf");
//        locationToMap(file);
//        String test = "三岔子锰矿区三岔子矿段 SZK041 钻孔柱状图";
//        System.out.println(test.replaceAll("\\d{1,2}\\.\\d{1,2}.*",""));
    }
}

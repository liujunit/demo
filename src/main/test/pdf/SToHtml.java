package pdf;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SToHtml {


        /**
         * S的pdf解析
         * @param file
         * @return
         */
        public static StringBuffer toHtmlString(File file) throws IOException {
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            PDDocument doc= PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper() {
                Map<TextPosition, Integer> renderingMode = new HashMap<TextPosition, Integer>();
                @Override
                protected void processTextPosition(TextPosition text) {
                    this.renderingMode.put(text, getGraphicsState().getTextState().getRenderingMode().intValue());
                    super.processTextPosition(text);
                }
                @Override
                protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
                    boolean flag = false;
                    if ("/".equals(text)) flag = true;
                    StringBuilder builder = new StringBuilder();
                    String fontFamily = "宋体";
                    boolean flag2 = false;
                    List<TextPosition> textPositionList = new ArrayList<>();
                    for (int i = 0; i < textPositions.size(); i++) {
                        //Unicode码
                        String content = textPositions.get(i).getUnicode();
                        content = content.replaceAll("\\s+| "," ").replaceAll("&","&amp;").replaceAll("\\<","＜").replaceAll("\\>","＞");
                        if (!" ".equals(content) || flag2) {
                            textPositionList.add(textPositions.get(i));
                            flag2 = true;
                        }
                    }
                    for (int i = 0; i < textPositionList.size(); i++) {
                        if (flag) continue;
                        TextPosition textPosition = textPositionList.get(i);
                        //获取字体大小
                        int fontSizeInPt = Math.round(textPosition.getFontSizeInPt()*1.5f);
                        if (fontSizeInPt < 0){
                            fontSizeInPt = Math.abs(fontSizeInPt/10);
                        }
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
                        content = content.replaceAll("\\s+| "," ").replaceAll("&","&amp;").replaceAll("\\<","＜").replaceAll("\\>","＞");
                        Integer isBold = renderingMode.get(textPosition);
                        if (null==isBold){
                            if ((i+1) < textPositionList.size()){
                                isBold = renderingMode.get(textPositionList.get(i + 1));
                            }else {
                                isBold = 0;
                            }
                        }
                        if ("Times New Roman".equals(fontType)) {
                            fontType = fontFamily;
                        } else {
                            fontFamily = fontType;
                        }
                        fontType = fontType + "+" + isBold;
                        if (textPositionList.size()==1){
                            builder.append("<font height=\""+ fontHeight +"\" width=\""+ fontWidth +"\" style=\"font-family:"+ fontType +"; font-size:" + fontSizeInPt + "px; padding-left:" + indent + "px;    \">" + content + "</font>");
                        }else {
                            if (i==0){
                                builder.append("<font height=\""+ fontHeight +"\" width=\""+ fontWidth +"\" style=\"font-family:"+ fontType +"; font-size:" + fontSizeInPt + "px; padding-left:" + indent + "px;  \">" + content);
                            }else if (i==(textPositionList.size()-1)){
                                builder.append(content+"</font>");
                            }else {
                                builder.append(content);
                            }
                        }
                    }
                    writeString(builder.toString());
                }
            };
            stripper.setSuppressDuplicateOverlappingText(false);
            String content = stripper.getText(doc);
            String[] contentSplit = content.split("\t|\r|\n");
            List<String> contentList = new ArrayList<>();
            String fontFamilySize = "";
            int padLeft = 0;
            for (String s : contentSplit) {
                if (!"".equals(s)) {
                    String isEmpty = s.substring(s.indexOf(">") + 1, s.indexOf("</"));
                    if (!"".equals(isEmpty.trim().replaceAll(" ",""))) {
                        //判断是否是多个font标签
                        int count = StringUtils.countMatches(s, "</font>");
                        if (count > 1) {
                            String a1 = s.substring(0, s.indexOf(">") + 1);
                            String a2 = s.substring(s.indexOf(">") + 1, s.lastIndexOf("</font>"));
                            a2 = a2.replaceAll("</font>","").replaceAll("<font.*?>", "");
                            s = a1 + a2 + "</font>";
                        }
                        //判断是不是页码
                        String isNum = s.substring(s.indexOf(">") + 1, s.lastIndexOf("</font>")).replaceAll("\\s+|-|―","");
                        if (!pattern.matcher(isNum).matches()) {
                            Map<String, String> match = match(s);
                            String fontFamily = match.get("font-family");
                            String fontSize = match.get("font-size");
                            String thisPadLeft = match.get("padding-left");
                            int thisPadLeftNum = Integer.valueOf(thisPadLeft.substring(0, thisPadLeft.indexOf("px")));
                            if (s.substring(s.indexOf(">") + 1, s.lastIndexOf("</font>")).startsWith(" ")) {
                                thisPadLeftNum = thisPadLeftNum + 20;
                            }
                            String thisFontFamilySize = fontFamily + fontSize;
                            if (thisFontFamilySize.equals(fontFamilySize) && (thisPadLeftNum < padLeft ||(thisFontFamilySize.contains("黑体") && fontFamilySize.contains("黑体") && thisPadLeftNum != padLeft))) {
                                contentList.add(s.substring(s.indexOf(">") + 1, s.lastIndexOf("</font>")));
                            } else {
                                contentList.add(s);
                                fontFamilySize = thisFontFamilySize;
                                padLeft = thisPadLeftNum;
                            }
                        }
                    }
                }
            }
            Map<Integer, String> contentMap = new HashMap<>();
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < contentList.size(); i++) {
                if (contentList.get(i).contains("</font>")) {
                    contentMap.put(i, contentList.get(i));
                    index.add(i);
                } else {
                    Set<Integer> keys = contentMap.keySet();
                    Integer max = Collections.max(keys);
                    String value = contentMap.get(max);
                    value = value.replace("</font>", contentList.get(i) + "</font>");
                    contentMap.put(max, value);
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<!DOCTYPE html>\n<html>\n<head></head>\n<body>\n");
            for (Integer integer : index) {
                String s = "<p>" + contentMap.get(integer) + "</p>" + "\n";
                stringBuffer.append(s);
            }
            stringBuffer.append("</body>\n</html>");
            doc.close();
            return stringBuffer;
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
                int one = r.indexOf("\"");
                int second = r.indexOf("\"", one + 1);
                r = r.substring(one + 1, second);
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




        public static void main(String[] args) throws IOException {
            File file = new File("E:\\西安\\S文件\\S01_7217.pdf");
            StringBuffer stringBuffer = toHtmlString(file);
            String[] split = stringBuffer.toString().split("\n");
            for (String s : split) {
                System.out.println(s);
            }
        }


}

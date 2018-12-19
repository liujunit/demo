package word;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liujun
 * 生成word文档的工具类，使用Apache的POI，此方法只针对文本做处理
 */
public class CreateWordDemo2 {

    private static int titleSize = 16;
    private static int contentSize = 13;
    private static String fontFamily = "宋体";

    /**
     * 生成word文件
     * @param contentMap key是标题 value是内容
     * @param fileName 文件的名称
     */
    public static void downLoadWord(Map<String, String> contentMap, String fileName) {
        //创建生成word的模板
        XWPFDocument doc = new XWPFDocument();
        for (String title: contentMap.keySet()) {
            //生成标题
            createTitle(doc.createParagraph(), title);
            //生成内容
            createContent(doc.createParagraph(), contentMap.get(title));
        }
        String path = "D:\\" + fileName + ".doc";
        //这里的流可以集成到项目中作为下载
        OutputStream os = null;
        try {
            os = new FileOutputStream(path);
            doc.write(os);
            System.out.println("完成：" + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 生成标题部分
     * @param title
     * @return
     */
    public static void createTitle(XWPFParagraph para, String title) {
        para.setAlignment(ParagraphAlignment.LEFT);//设置左对齐
        XWPFRun run = para.createRun();
        run.setFontFamily(fontFamily);
        run.setBold(true);
        run.setFontSize(titleSize);
        run.setText(title);
    }

    /**
     * 生成段落部分
     * @param content
     * @return
     */
    public static void createContent(XWPFParagraph para, String content) {
        para.setAlignment(ParagraphAlignment.NUM_TAB);//设置左对齐
        XWPFRun run = para.createRun();
        run.setFontFamily(fontFamily);
        run.setFontSize(contentSize);
        //首行缩进
        run.setText("   " + content);
    }

    public static void main(String[] args) {
        //使用有序map
        Map<String, String> wordMap = new LinkedHashMap<>(16);
        wordMap.put("测试标题1", "测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1测试内容1");
        wordMap.put("测试标题2", "测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2");
        wordMap.put("测试标题3", "测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3测试内容3");
        wordMap.put("测试标题4", "测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4测试内容4");
        wordMap.put("测试标题5", "测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5测试内容5");
        downLoadWord(wordMap, "测试word生成");
    }

}

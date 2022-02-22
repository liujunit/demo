package word;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用easy-poi生成word
 */
public class CreateWordDemo3 {

    /**
     * 简单导出没有图片和Excel
     */
    @Test
    public void SimpleWordExport() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("department", "Easypoi");
        map.put("hjlxr", "    张三");
//        map.put("time", format.format(new Date()));
//        map.put("me","JueYue");
//        map.put("date", "2015-01-03");
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(
                    "F:\\材料\\option-template.docx", map);
            FileOutputStream fos = new FileOutputStream("F:\\材料\\simple.docx");
            doc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

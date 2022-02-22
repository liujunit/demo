package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PDFBoxTest {

    @Test
    public void test01() throws IOException {
        PDDocument doc = PDDocument.load(new File("F:/高清电子版-Netty 实战(精髓).pdf"));
        doc.setAllSecurityToBeRemoved(true);
        int count = doc.getPages().getCount();
        for (int i = 0; i < count; i++) {
            PDPage page = doc.getPage(i);
            PDFont font = PDType0Font.load(doc, new File("F:/simfang.ttf"));
            //涉密页进行涉密处理
            if (i == 10) {
                PDPageContentStream cs1 = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.OVERWRITE, true,
                        true);
                String ts1 = "机密";
                PDExtendedGraphicsState r1 = new PDExtendedGraphicsState();
                // 透明度
                r1.setNonStrokingAlphaConstant(0.2f);
                r1.setAlphaSourceFlag(true);
                cs1.setGraphicsStateParameters(r1);
                cs1.setNonStrokingColor(0, 0, 0);// Red
                cs1.beginText();
                float fontSize = 55.0f;
                cs1.setFont(font, fontSize);
                // 获取旋转实例
                cs1.setTextMatrix(Matrix.getRotateInstance(0,  460f, 780f));
                cs1.showText(ts1);
                cs1.endText();
                cs1.close();
                continue;
            }
            PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true,
                    true);
            String ts = "陕西地质资料馆";

            PDExtendedGraphicsState r0 = new PDExtendedGraphicsState();
            // 透明度
            r0.setNonStrokingAlphaConstant(0.2f);
            r0.setAlphaSourceFlag(true);
            cs.setGraphicsStateParameters(r0);
            cs.setNonStrokingColor(200, 0, 0);// Red
            cs.beginText();
            float fontSize = 25.0f;
            cs.setFont(font, fontSize);
            // 获取旋转实例
            for (int x = 0; x < 7; x++) {
                for (int y = 0; y < 9; y++) {
                    cs.setTextMatrix(Matrix.getRotateInstance(19.5, x * 90f, y * 120f));
                    cs.showText(ts);
                }
                x++;
            }
            cs.endText();
            cs.close();
        }
        File tmpFile = new File("F://test.pdf");
        doc.save(tmpFile);
    }

}

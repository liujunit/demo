package word;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

public class CreateWordDemo1 {

    public static void main(String[] args) throws IOException {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph para;
        XWPFRun run;
        //添加文本
        String content = "    额尔古纳河在1689年的《中俄尼布楚条约》中成为中国和俄罗斯的界河，额尔古纳河上游称海拉尔河，源于大兴安岭西侧，西流至阿该巴图山脚， 折而北行始称额尔古纳河。额尔古纳河在黑龙江省漠河县以西的内蒙古自治区额尔古纳右旗的恩和哈达附近与流经俄罗斯境内的石勒喀河汇合后始称黑龙江。沿额尔古纳河沿岸地区土地肥沃，森林茂密，水草丰美， 鱼类品种很多，动植物资源丰富，宜农宜木，是人类理想的天堂。";
        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.LEFT);//设置左对齐
        run = para.createRun();
        run.setFontFamily("仿宋");
        run.setFontSize(13);
        run.setText(content);
        doc.createParagraph();
        //添加图片
//        String[] imgs = {"D:\\bar.png", "D:\\pie.png"};
//        for (
//                int i = 0;
//                i < imgs.length; i++)

//        {
        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.CENTER);//设置左对齐
//        run = para.createRun();
//            InputStream input = new FileInputStream(imgs[i]);
//            run.addPicture(input, XWPFDocument.PICTURE_TYPE_JPEG,
//                    imgs[i], Units.toEMU(350), Units.toEMU(170));
        para = doc.createParagraph();
        para.setAlignment(ParagraphAlignment.CENTER);//设置左对齐
        run = para.createRun();
        run.setFontFamily("仿宋");
        run.setFontSize(11);
//            run.setText(imgs[i]);
//        }
        doc.createParagraph();
        //添加表格
        XWPFTable table = doc.createTable(2, 3);
        table.setCellMargins(3, 5, 3, 5);
        //        table.addNewCol();//添加新列
//        table.createRow();//添加新行
        String[] title = new String[]{"境内河流", "境外河流", "合计"};
        String[] value = new String[]{"1", "2", "3"};
        XWPFTableRow row;
        XWPFTableCell cell;
        CTTcPr cellPr;
        for (int j = 0; j < 2; j++) {
            row = table.getRow(j);
            row.setHeight(400);
            for (int i = 0; i < title.length; i++) {
                cell = row.getCell(i);
                cellPr = cell.getCTTc().addNewTcPr();
                cellPr.addNewTcW().setW(BigInteger.valueOf(3000));
                para = cell.getParagraphs().get(0);
                para.setAlignment(ParagraphAlignment.CENTER);
                run = para.createRun();
                run.setFontFamily("仿宋");
                run.setFontSize(11);
                if (j == 0) {//标题
                    run.setBold(true);
                    run.setText(title[i]);
                } else {
                    run.setText(value[i]);
                }
            }
        }
        String path = "D:\\test.doc";
        OutputStream os = new FileOutputStream(path);
        doc.write(os);
        if (os != null) {
            try {
                os.close();
                System.out.println("文件已输出！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

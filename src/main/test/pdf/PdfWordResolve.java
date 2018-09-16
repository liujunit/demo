package pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PdfWordResolve {

    public static void main(String[] args) throws IOException {
        String path = "F:\\西安\\测试数据";
        //遍历文件夹下的所有的文件
        getAllFiles(path);
    }

    public static void getAllFiles(String path) throws IOException {
        File file = new File(path);
        File[] files = file.listFiles();
        if (files.length > 0){
            for (File f : files) {
                if (f.isDirectory()){
                    getAllFiles(f.getAbsolutePath());
                }else {
                    String name = f.getName();
                    if (name.contains(".")){
                        String[] split = name.split("\\.");
                        if ("z01_0001".equals(split[0].toLowerCase()) && ("pdf".equals(split[1]) || "doc".equals(split[1]) || "docx".equals(split[1]))) {
                            if ("pdf".equals(split[1])){
                                System.out.println(f.getAbsolutePath());
                                pdfParse(f);
                            }else if ("doc".equals(split[1])){
                                docParse(f);
                            }else if ("docx".equals(split[1])){
                                docxParse(f);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 解析pdf
     */
    public static void pdfParse(File file) throws IOException {
        PDDocument doc= PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        String text = pdfTextStripper.getText(doc);
        String[] split = text.split("\t?\r");
    }

    /**
     * 解析doc
     */
    public static void docParse(File file){
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            str = doc.getDocumentText();
            String[] split = str.split("\t?\r");
            for (String s : split) {
                System.out.println(s);
            }
            doc.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

    /**
     * 解析docx
     * @param file
     */
    public static void docxParse(File file){
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            XWPFDocument xdoc = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            str = extractor.getText();
            String[] split = str.split("\t?\r");
            for (String s : split) {
                System.out.println(s);
            }
            extractor.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }

}

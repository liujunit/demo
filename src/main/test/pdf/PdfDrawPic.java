package pdf;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class PdfDrawPic {

    public static void getPic(String filePath, String imgPath) throws IOException {
        File imgDir = new File(imgPath);
        if (!imgDir.exists()) {
            //生成文件夹
            imgDir.mkdirs();
        }
        File file = new File(filePath);
        PDDocument document = PDDocument.load(file);
        //获取总页数
        int pageNum = document.getNumberOfPages();
        for (int i = 0; i < pageNum; i++) {
            PDPage page = document.getPage(i);
            PDResources resources = page.getResources();
            Iterable<COSName> xObjectNames = resources.getXObjectNames();
            int count = 1;
            for (COSName cosName : xObjectNames) {
                if (page.getResources().isImageXObject(cosName)) {
                    PDXObject xObject = page.getResources().getXObject(cosName);
                    PDImageXObject pdImageXObject = (PDImageXObject) xObject;
                    BufferedImage image = pdImageXObject.getImage();
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    ImageIO.write(image, pdImageXObject.getSuffix(), os);
                    ByteArrayInputStream inputStream = new ByteArrayInputStream(os.toByteArray());
                    //图片名的生成规则：页码-图片在当前页面第几次出现.后缀
                    File imgFile = new File(imgPath + i + "-" + count + "." + pdImageXObject.getSuffix());
                    imgFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(imgFile);
                    int byteContent = 0;
                    byte[] bytes = new byte[1024];
                    while ((byteContent = inputStream.read(bytes)) > 0) {
                        fos.write(bytes, 0, byteContent);
                    }
                    //设置打印Log
                    System.out.println("提取图片：" + imgFile.getName());
                    fos.flush();
                    fos.close();
                    inputStream.close();
                    os.close();
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //需要解析的pdf的路径
        String filePath = "E:\\西安\\S01_0001.pdf";
        //解析后图片保存的位置
        String imgPath = "E:\\测试生成pdf图片\\";
        getPic(filePath, imgPath);
    }

}

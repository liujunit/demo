package pdf;

import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

public class PdfToWord{
    public static void main(String[] args){
        PdfDocument pdf = new PdfDocument("C:\\Users\\15631\\OneDrive\\桌面\\2019不惑高频考点【】.pdf");
        pdf.saveToFile("C:\\Users\\15631\\OneDrive\\桌面\\Test.docx", FileFormat.DOCX);
        System.out.println("****************");
    }
}
package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 */
public class XmlFormatter {

    public static void main(String[] args) throws DocumentException, IOException {
        FileReader fr = new FileReader("E:\\西安\\桌面杂数据\\jcr.xml");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String xml = "";
        while ((line = br.readLine()) != null) {
            xml += line;
        }
        Document outDoc = DocumentHelper.parseText(xml);
        OutputFormat format = OutputFormat.createPrettyPrint();  //转换成字符串
        format.setEncoding("UTF-8");
        FileWriter fw = new FileWriter("E:\\西安\\桌面杂数据\\jcrFormat.xml");
        XMLWriter writer = new XMLWriter(fw, format);
        writer.write(outDoc);
        fw.close();
        br.close();
        fr.close();
        System.out.println("完成");
    }

    @Test
    public void test() {

        String uid = "C1FEDCB946C14305B7AF5BCCF6279F4F";
        System.out.println(uid.toLowerCase());

    }
}
package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class XzqTest {


    @Test
    public void test01() throws DocumentException {
        // 创建SAXReader实例
        SAXReader reader;
        reader = new SAXReader();
        // read()读取指定的XML文档并形成DOM树
        Document document = reader.read(new File("D:/Program Files/EDMAKER2017/Params/Region.xml"));
        // getRootElement()获取根节点
        Element rootEle = document.getRootElement();
        // elements()获取根节点的子节点
        List<Element> bookEles = rootEle.elements();
        // 遍历子节点
        int id = 1;
        for (int i0 = 0; i0 < bookEles.size(); i0++) {
            Element book = bookEles.get(i0);
            String name = book.attribute("Name").getValue();
            String code = book.attribute("Code").getValue();
            if (code.equals("000000")) {
                continue;
            }
            System.out.println("insert into e_city VALUES (" + id + ", \""+ name +"\", \""+ code +"\", 0);");
            int parentId = id;
            id++;
            List citys = book.elements("City");
            for (int i = 0; i < citys.size(); i++) {
                Element city = (Element) citys.get(i);
                String cityName = city.attribute("Name").getValue();
                String cityCode = city.attribute("Code").getValue();
                System.out.println("insert into e_city VALUES (" + id + ", \""+ cityName +"\", \""+ cityCode +"\", "+ parentId +");");
                int parentId2 = id;
                id++;
                List districts = city.elements("District");
                for (int i1 = 0; i1 < districts.size(); i1++) {
                    Element district = (Element) districts.get(i1);
                    String districtName = district.attribute("Name").getValue();
                    String districtCode = district.attribute("Code").getValue();
                    System.out.println("insert into e_city VALUES (" + id + ", \""+ districtName +"\", \""+ districtCode +"\", "+ parentId2 +");");
                    id++;
                }
            }
        }
    }


    @Test
    public void test02() throws DocumentException {
        // 创建SAXReader实例
        SAXReader reader;
        reader = new SAXReader();
        // read()读取指定的XML文档并形成DOM树
        Document document = reader.read(new File("D:/Program Files/EDMAKER2017/Params/Region.xml"));
        // getRootElement()获取根节点
        Element rootEle = document.getRootElement();
        // elements()获取根节点的子节点
        List<Element> bookEles = rootEle.elements();
    }
}

package pdf;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by jiuyuan4 on 2018/7/16.
 */
public class DomTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory df =  DocumentBuilderFactory.newInstance();
        DocumentBuilder db = df.newDocumentBuilder();
        //Document document = db.parse(stringBuffer.toString());
        Document document = db.parse("file:///" + "C:\\Users\\jiuyuan4\\Desktop\\资料\\sa.xml");
        NodeList fList = document.getElementsByTagName("font");
        for (int i = 0; i < fList.getLength(); i++) {
            Node item = fList.item(i);
            //通过Node对象的getAttributes()方法获取全的属性值
            NamedNodeMap fontMap = item.getAttributes();
            Node styleNode = fontMap.getNamedItem("style");
            String styleNodeNodeValue = styleNode.getNodeValue();
            String[] split = styleNodeNodeValue.split(";");
            for (String s : split) {
                String[] split1 = s.trim().split(":");
                if ("font-family".equals(split1[0])){
                    System.out.println("font-family:" + split1[1]);
                }
                if ("font-size".equals(split1[0])){
                    System.out.println("font-size:" + split1[1]);
                }
            }
            //节点内容
            String nodeValue = item.getFirstChild().getNodeValue();
            System.out.println(nodeValue);
        }
    }

}

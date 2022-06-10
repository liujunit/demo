package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Field;
import java.util.List;

public class NoteXmlParse {

    public static void main(String[] args) {
        //使用dom4j进行xml解析
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read("./note.xml");
            Element rootElement = doc.getRootElement();
            List<Element> elements = rootElement.elements();
            Note note = new Note();
            Class<? extends Note> aClass = note.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Element element : elements) {
                String name = element.getName();
                Object data = element.getData();
                //使用java反射设置属性
                for (Field declaredField : declaredFields) {
                    if (declaredField.getName().equals(name)) {
                        declaredField.setAccessible(true);
                        String type = declaredField.getType().getName();
                        //针对不同类型做处理
                        if (type.equals("int")) {
                            Integer intData = Integer.valueOf(data.toString());
                            declaredField.set(note, intData);
                        } else {
                            declaredField.set(note, data);
                        }
                    }
                }
            }
            System.out.println(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

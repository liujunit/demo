package pdf;

import com.github.sd4324530.jtuple.Tuple3;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.*;

public class DomResolve {

    /**
     * 三元组样式集合的返回
     * @param file
     * @return
     */
    public static List<Tuple3<Integer, String, Integer>> createTuple3s(File file){
        Document document = null;
        //声明一个三元组集合
        List<Tuple3<Integer, String, Integer>> list = new ArrayList<>();
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(new ByteArrayInputStream(PdfToHtml.toHtmlString(file).toString().getBytes()));
            List<?> fontLists = document.selectNodes("/html/body//font");
            ArrayList<Paragh> ps = new ArrayList<Paragh>();
            TreeSet<Integer> fontsizeSet = new TreeSet<Integer>((o1 , o2) ->o1.compareTo(o2));
            TreeSet<String> fontfamilySet = new TreeSet();
            int idCount = 0;
            for (Iterator<?> it = fontLists.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                // do something
                Paragh p = new Paragh();
                String[] vals = elm.attribute("style").getStringValue().split(";");
                for (String v : vals) {
                    if (v.contains("font-family")) {
                        p.fontFamily = v.split(":")[1].trim();
                        fontfamilySet.add(p.fontFamily);
                    }
                    if (v.contains("font-size")) {
                        p.fontSize = Integer.parseInt(v.split(":")[1].replaceAll("px", "").trim());
                        fontsizeSet.add(p.fontSize);
                    }
                }
                p.Id = idCount;
                p.text = elm.getText();
                p.raw = elm.asXML();
                ps.add(p);
                idCount++;
            }
            //样式计数
            Map<Paragh, Integer> styleCount = new HashMap<Paragh, Integer>();
            for(Paragh p : ps ) {
                if(styleCount.containsKey(p)) {
                    styleCount.put(p, styleCount.get(p)+1);
                } else {
                    styleCount.put(p, 1);
                }
            }
            String [] clss= {"h1", "h2", "h3", "h4", "正文"};
            HashMap<Integer, String> classMap = new  HashMap<Integer, String>();
            Iterator<Integer> it = fontsizeSet.iterator();
            int id = 0;
            while (it.hasNext()) {
                if(id > 3 ) {
                    //System.out.println(i.next() + clss[3]);
                    classMap.put(it.next(), clss[3]);
                } else {
                    //System.out.println(i.next() + clss[id]);
                    classMap.put(it.next(), clss[id]);
                }
                id++;
            }

            for (Paragh p : ps ) {
                p.clss = classMap.get(p.fontSize);
//                System.out.println("标题： " + p.clss);
//                System.out.println("xml： " + p.raw);
            }

            styleCount.forEach((a, b) -> {
                String[] split = String.valueOf(a).split(",");
                Integer first = Integer.valueOf(split[0].split(":")[1]);
                String second = split[1].split(":")[1];
                Tuple3<Integer, String, Integer> with = Tuple3.with(first, second, b);
                list.add(with);
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\jiuyuan4\\Desktop\\资料\\存档电子文件\\Z01_01.pdf");
        List<Tuple3<Integer, String, Integer>> tuple3s = createTuple3s(file);
        for (int i = 0; i < tuple3s.size(); i++) {
            Tuple3<Integer, String, Integer> tuple3 = tuple3s.get(i);

            for (Object o : tuple3) {
                System.out.println(Objects.toString(o));
            }
        }
    }

}

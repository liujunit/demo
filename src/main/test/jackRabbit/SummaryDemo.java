package jackRabbit;

import org.apache.jackrabbit.core.jndi.RegistryHelper;
import org.apache.jackrabbit.core.jndi.provider.DummyInitialContextFactory;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.query.Query;
import javax.jcr.query.QueryResult;
import javax.jcr.query.Row;
import javax.jcr.query.RowIterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Hashtable;

public class SummaryDemo {

    public static void main(String[] args) throws Exception {
        // 初始化仓库
        String configFile = "F:\\jyth\\rep_mem\\repository.xml";
        String repHomeDir = "F:\\jyth\\rep_mem";
        String path = "C:\\Users\\jiuyuan4\\Desktop\\摘要.txt";
        Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
        hashTable.put(Context.INITIAL_CONTEXT_FACTORY,
                DummyInitialContextFactory.class.getName());
        hashTable.put(Context.PROVIDER_URL, "127.0.0.1");
        InitialContext ctx = new InitialContext(hashTable);
        RegistryHelper.registerRepository(ctx, "repo", configFile, repHomeDir,
                true);
        Repository repository = (Repository) ctx.lookup("repo");
        // 登陆.这里注意一点，需要以管理员的身份登陆，否则很多操作都没有权限，默认用户名和密码都是admin
        SimpleCredentials cred = new SimpleCredentials("admin", "admin".toCharArray());
        // 创建一个session
        Session session = repository.login(cred);
        String xpath = "//element(*, udm:DocCatalogNode)[jcr:contains(.,'摘')]/rep:excerpt(.)";
        Query query = session.getWorkspace().getQueryManager().createQuery(xpath, Query.XPATH);
        QueryResult result = query.execute();
        RowIterator rows = result.getRows();
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        while (rows.hasNext()){
            Row row = (Row) rows.next();
            Node node = row.getNode();
            if (node.hasProperty("udm_title")){
                String title = node.getProperty("udm_title").getString().replaceAll(" ","");
                if (title.contains("摘要")){
                    String mc = "";
                    String ztc = "";
                    String zy = "";
                    //获取最根节点
                    Node rootNode = node.getParent().getParent();
                    //获取名称
                    if (rootNode.hasProperty("pkiia")){
                        mc = rootNode.getProperty("pkiia").getString();
                    }
                    //获取主题词
                    if (rootNode.hasProperty("ztc")){
                        ztc = rootNode.getProperty("ztc").getString();
                    }
                    //获取摘要
                    System.out.println( title + ":" + node);
                    if (node.hasProperty("jcr:data")){
                        zy = node.getProperty("jcr:data").getString().replaceAll("\r?\t?\n","");
                        String line = mc + ";" + ztc + ";" + zy;
                        System.out.println(line);
                        bw.write(line);
                        bw.newLine();
                        bw.flush();
                    }
                }
            }
        }
        bw.close();


    }


}

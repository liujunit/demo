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
import java.util.Hashtable;

/**
 * 库id获取
 */
public class JackIdDemo {

    public static void main(String[] args) throws Exception {
        // 初始化仓库
        String configFile = "F:\\西安\\rep_fs\\repository.xml";
        String repHomeDir = "F:\\西安\\rep_fs";
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
        String xpath = "//element(*, udm:MainBody)";
        Query query = session.getWorkspace().getQueryManager().createQuery(xpath, Query.XPATH);
        QueryResult result = query.execute();
        RowIterator rows = result.getRows();
        while (rows.hasNext()) {
            Row row = (Row) rows.next();
            Node node = row.getNode();
            String pkiib = node.getProperty("pkiib").getString();
            String uuid = node.getProperty("jcr:uuid").getString();
//            System.out.println(pkiib + ":" + uuid);
            System.out.println("UPDATE DIRECTORY_DATA SET \"uuid\"='"+ uuid +"' WHERE \"pkiib\"='"+ pkiib +"';");
        }
    }

}

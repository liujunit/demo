package jackRabbit;

import org.apache.jackrabbit.core.jndi.RegistryHelper;
import org.apache.jackrabbit.core.jndi.provider.DummyInitialContextFactory;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

/**
 * @author not ahuaxuan
 * @since 2009-5-19
 * @version $Id$
 */
public class HopFirst {

    /**
     * Second hop example. Stores, retrieves, and removes example content.
     */

    /**
     * The main entry point of the example application.
     *
     * @param args
     *            command line arguments (ignored)
     * @throws Exception
     *             if an error occurs
     */
    public static void main(String[] args) throws Exception {
        // 初始化仓库
        String configFile = "F:\\jyth\\repository.xml";
        String repHomeDir = "F:\\jyth\\repository";
        Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
        hashTable.put(Context.INITIAL_CONTEXT_FACTORY,
                DummyInitialContextFactory.class.getName());
        System.out.println("--------->" + DummyInitialContextFactory.class.getName());
        hashTable.put(Context.PROVIDER_URL, "127.0.0.1");
        InitialContext ctx = new InitialContext(hashTable);
        RegistryHelper.registerRepository(ctx, "repo", configFile, repHomeDir,
                true);
        Repository repository = (Repository) ctx.lookup("repo");

        // 登陆.这里注意一点，需要以管理员的身份登陆，否则很多操作都没有权限，默认用户名和密码都是admin
        SimpleCredentials cred = new SimpleCredentials("admin",
                "admin".toCharArray());
        // 创建一个session
        Session session = repository.login(cred);
        try {
            // 得到根节点(发现root变量，root，一般树结构的顶层节点叫做root)
            Node root = session.getRootNode();

//            // 添加节点数据（仔细看hello节点和world节点的组织方式，可以发现它是一颗树形结构）
//            Node hello = root.addNode("hello");
//            Node world = hello.addNode("world");
//            world.setProperty("message", "Hello, World!");
//
//            // 保存数据
//            session.save();

            // 数据查询
            Node node = root.getNode("hello/world");
            System.out.println(node.getPath());
            System.out.println(node.getProperty("message").getString());

//            // 数据删除
//            root.getNode("hello").remove();
            session.save();
        } finally {
            session.logout();
        }
    }

}

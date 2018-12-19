package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OJDBCUtils {

    private static final String DRIVERNAME = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@192.168.50.165:1521:ORCL";
    private static final String USER = "geology";
    private static final String PASSWORD = "geology123";

    static {
        try {
            //1.注册驱动
            Class.forName(DRIVERNAME);
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动失败");
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws SQLException {
        //2.获取连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.返回连接
        return conn;
    }

}

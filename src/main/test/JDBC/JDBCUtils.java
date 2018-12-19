package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "asdfmin";

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

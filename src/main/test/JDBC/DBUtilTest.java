package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtilTest {

    /**
     * 测试封装的JDBCUtil
     */
    @Test
    public void test01() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConn();
            //2.获取执行语句
            String sql = "select * from user";
            preparedStatement = conn.prepareStatement(sql);
            //3.添加占位符
            //4.执行预处理语句
            resultSet = preparedStatement.executeQuery();
            //5.遍历结果集
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("name:" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

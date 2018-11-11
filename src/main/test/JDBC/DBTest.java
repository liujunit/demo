package JDBC;

import org.junit.Test;

import java.sql.*;

public class DBTest {

    /**
     * 增
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test01() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "asdfmin");
        //3.获得预处理语句
        String sql = "insert into user (name, sex, age) values (? , ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //4.添加占位符
        preparedStatement.setString(1, "jack");
        preparedStatement.setString(2, "男");
        preparedStatement.setString(3, "18");
        //5.执行预处理语句
        int i = preparedStatement.executeUpdate();
        System.out.println("添加新记录条数：" + i);
        //6.释放资源
        preparedStatement.close();
        conn.close();
    }

    /**
     * 更
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test02() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "asdfmin");
        //3.获取预处理语句
        String sql = "update user set age = ? where name = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //4.添加占位符
        preparedStatement.setString(1, "19");
        preparedStatement.setString(2, "jack");
        //5.执行预处理语句
        int i = preparedStatement.executeUpdate();
        System.out.println("更新记录条数：" + i);
        //6.释放资源
        preparedStatement.close();
        conn.close();
    }

    /**
     * 删
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test03() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "asdfmin");
        //3.获取预处理语句
        String sql = "delete from user where id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //4.添加占位符
        preparedStatement.setString(1, "1");
        //5.执行预处理
        int i = preparedStatement.executeUpdate();
        System.out.println("删除记录条数：" + i);
        //6.释放资源
        preparedStatement.close();
        conn.close();
    }

    /**
     * 查
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Test
    public void test04() throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "asdfmin");
        //3.获取预处理语句
//        String sql = "select * from user";
        String sql = "select * from user where name = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //4.添加站位符
        preparedStatement.setString(1, "jack");
        //5.执行预处理
        ResultSet resultSet = preparedStatement.executeQuery();
        //6.遍历结果集
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            String age = resultSet.getString("age");
            System.out.println("id:" + id + "   name:" + name + "  set:" + sex + "  age:" + age);
        }
        //7.关闭资源
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }

}

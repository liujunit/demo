package JDBC;

import nio.FileChannelDemo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import util.UuidUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

public class SQLTest {

    private static final Logger log = Logger.getLogger("SQLTest");


    @Test
    public void test01() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Queue<String> queue = new LinkedList<String>();
            //1.获取连接
            conn = JDBCUtils.getConn();
            //2.获取执行语句
            int count = 1;
            List<String> fileText = getFileText();
            for (int i = 0; i < 2000; i++) {
                for (String s : fileText) {
                    queue.add(s);
                    if (queue.size() == 10) {
                        //3.添加占位符
                        String sql = "insert into user values ('" + UuidUtil.get32UUID() + "', '" + queue.poll() + "','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"','"+ queue.poll() +"')";
                        preparedStatement = conn.prepareStatement(sql);
                        boolean execute = preparedStatement.execute();
                        log.info("执行插入数据:" + count + "-" + execute);
                        count++;
                    }
                }
            }
            //4.执行预处理语句
            //5.遍历结果集
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源
            try {
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文本文件
     * @return
     */
    public List<String> getFileText() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\15631\\Desktop\\sql文本测试.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        int count = 1;
        while ((line = bufferedReader.readLine()) != null) {
            line = line.trim().replaceAll("\\s+|\\d+|　　|　|；", "");
            if (StringUtils.isNotEmpty(line)) {
                String[] splitText = line.split("，|、|。");
                for (String s : splitText) {
                    if (StringUtils.isNotEmpty(s)) {
                        list.add(s);
                        count++;
                    }
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }

}

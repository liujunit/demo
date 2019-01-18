package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OJDBCTest {

    @Test
    public void test01() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            conn = OJDBCUtils.getConn();
            String sql = "select * from DZZL_CATALOG where NRTY is not null order by PKIIB";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            int count = 1;
            while (resultSet.next()) {
                int pkiib = Integer.parseInt(resultSet.getString("PKIIB"));
                String nrty = resultSet.getString("NRTY");
                if (pkiib < 6000) {
                    count++;
                    System.out.println(pkiib);
                    System.out.println(nrty);
                }
            }
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

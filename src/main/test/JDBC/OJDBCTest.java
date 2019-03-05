package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test02() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;
        try {
            conn = OJDBCUtils.getConn();
            String sql1 = "select min(ID) ID from CODE group by NAME, PID";
            preparedStatement = conn.prepareStatement(sql1);
            resultSet = preparedStatement.executeQuery();
            List<String> idList1 = new ArrayList<>();
            while (resultSet.next()) {
                idList1.add(resultSet.getString("ID"));
            }
            String sql2 = "select ID from CODE";
            preparedStatement2 = conn.prepareStatement(sql2);
            resultSet2 = preparedStatement2.executeQuery();
            List<String> idList2 = new ArrayList<>();
            while (resultSet.next()) {
                idList2.add(resultSet2.getString("ID"));
            }
            boolean b = idList2.removeAll(idList1);
            if (b) {
                for (int i = 0; i < idList2.size(); i++) {

                }
            }
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

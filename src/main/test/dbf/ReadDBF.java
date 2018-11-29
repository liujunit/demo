package dbf;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

/**
 * 读取DBF文件
 */
public class ReadDBF {

    public static void main(String[] args) {
        FileInputStream fis = null;
        DBFReader dr = null;
        try {
            fis = new FileInputStream("E:\\西安\\目录元数据\\20170726.DBF");
            dr = new DBFReader(fis);
            int fieldCount = dr.getFieldCount();
            for (int i = 0; i < fieldCount; i++) {
                DBFField field = dr.getField(i);
                String name = field.getName();
                DBFDataType type = field.getType();
                int length = field.getLength();
            }
            //创建内容
            int recordCount = dr.getRecordCount();
            for (int i = 0; i < recordCount; i++) {
                DBFRow dbfRow = dr.nextRow();
                Object nrty = dbfRow.getObject("nrty");
                System.out.println(nrty);
                System.out.println(dbfRow.getString("nrty"));
            }
            Charset charset = dr.getCharset();
            System.out.println(charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

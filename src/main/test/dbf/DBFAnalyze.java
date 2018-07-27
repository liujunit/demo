package dbf;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFUtils;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;

import java.io.*;

/**
 * Created by jiuyuan4 on 2018/7/27.
 */
public class DBFAnalyze {

    @Test
    public void read(){
        DBFReader reader = null;
        try {
            // create a DBFReader object
            reader = new DBFReader(new FileInputStream(new File("C:\\Users\\jiuyuan4\\Desktop\\西安\\目录数据dbf\\20170726.DBF")));
            // get the field count if you want for some reasons like the following
            int numberOfFields = reader.getFieldCount();
            // use this count to fetch all field information
            // if required
            //创建一个excel
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFSheet sheet = hssfWorkbook.createSheet("陕西地质");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = hssfWorkbook.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 创建一个居左格式
            //声明列对象
            HSSFCell cell = null;
            //创建表头
            for (int i = 0; i < numberOfFields; i++) {
                DBFField field = reader.getField(i);
                System.out.println("生成表头："+field.getName());
                cell = row.createCell(i);
                cell.setCellValue(field.getName());
                cell.setCellStyle(style);
            }
            // 创建内容
            Object[] rowObjects;
            int a = 1;
            while ((rowObjects = reader.nextRecord()) != null) {
                row = sheet.createRow(a);
                System.out.println("生成第"+ a +"行数据");
                for (int i = 0; i < rowObjects.length; i++) {
//                    System.out.println(rowObjects[i]);
                    row.createCell(i).setCellValue(rowObjects[i]+"");
                }
                a++;
            }
            File file = new File("C:\\Users\\jiuyuan4\\Desktop\\西安\\sxdz.xlsx");
            OutputStream out = new FileOutputStream(file);    // 通过对象多态性，进行实例化
            hssfWorkbook.write(out);
            out.close();                        // 关闭输出流
            //文件不存在会自动创建
        } catch (DBFException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            DBFUtils.close(reader);
        }
    }
}

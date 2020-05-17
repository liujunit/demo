package poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel常用API记录(HSSFWorkbook)
 */
public class ExcelAPI {

    /**
     * 基本属性的设置 边框，字体，高度，宽度
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        //创建
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("这里是Sheet页");
        //列宽参考：https://blog.csdn.net/duqian42707/article/details/51491312
        sheet.setColumnWidth(2, 252 * 50 + 323);
        //创建行
        HSSFRow row = sheet.createRow(2);
        row.setHeightInPoints(10);
        //创建列
        HSSFCell cell = row.createCell(2);
        //指定单元格创建样式========================================================
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //边线设置
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //设置内容水平位置 居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置内容垂直位置 居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置字体换行
        cellStyle.setWrapText(true);
        //设置字体 font的属性扩展
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        //=============================================================================
        //单元格指定设置的样式
        //这里不能使用cell.getCellStyle().setBorderBottom()，在没设置之前得到的是全局样式，修改会改变全局
        cell.setCellStyle(cellStyle);
        cell.setCellValue("我是单元格");
        //输出
        FileOutputStream fos = new FileOutputStream("E:\\测试01.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("完成");
    }

    /**
     * 合并单元格操作，合并后的边线
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        //创建
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("这里是Sheet页");
        //创建行
        HSSFRow row = sheet.createRow(2);
        HSSFCell cell = row.createCell(3);
        cell.setCellValue("我是合并单元格");
        //参数：firstRow lastRow firstCol lastCol  注意：合并后的单元格文字指定的是左上角第一个单元格，其他单元格不生效
        CellRangeAddress cellRangeAddress = new CellRangeAddress(2, 5, 3, 5);
        sheet.addMergedRegion(cellRangeAddress);
        //合并后的边框线设置
        RegionUtil.setBorderLeft(1, cellRangeAddress, sheet);
        RegionUtil.setBorderRight(1, cellRangeAddress, sheet);
        RegionUtil.setBorderTop(1, cellRangeAddress, sheet);
        RegionUtil.setBorderBottom(1, cellRangeAddress, sheet);
        //输出
        FileOutputStream fos = new FileOutputStream("E:\\测试02.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("完成");
    }

    /**
     * 打印设置
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        //创建
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = workbook.createSheet("这里是Sheet页");
        //公用样式 边框线
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //边线设置
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //设置内容水平位置 居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置内容垂直位置 居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置字体换行
        cellStyle.setWrapText(true);
        //创建表头
        HSSFRow row0 = sheet.createRow(0);
        for (int i = 0; i < 10; i++) {
            HSSFCell cell = row0.createCell(i);
            cell.setCellValue("表头" + i);
            cell.setCellStyle(cellStyle);
        }
        //创建100行10列的数据
        for (int i = 1; i < 101; i++) {
            HSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                HSSFCell cell = row.createCell(j);
                cell.setCellValue("数据行" + i + "列" + j);
                cell.setCellStyle(cellStyle);
            }
        }
        //设置循环打印的范围
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 9);
        sheet.setRepeatingRows(cellRangeAddress);
        //设置循环打印的页脚 可编写页脚内容
        HSSFFooter footer = sheet.getFooter();
        footer.setLeft("左页脚");
        footer.setCenter("中页脚");
        footer.setRight("右页脚");
        //输出
        FileOutputStream fos = new FileOutputStream("E:\\测试03.xls");
        workbook.write(fos);
        fos.close();
        System.out.println("完成");
    }

}

package csvParse;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Test01 {

    @Test
    public void test01() throws Exception {

        FileReader fileReader = new FileReader("E:\\西安\\数据文件cvs\\ceshi.csv");
        BufferedReader bf = new BufferedReader(fileReader);
        String line = "";
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void test2() {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        String a = "- 9 - ";
        a = a.replaceAll("\\s+|-", "").replaceAll(" ", "");
        System.out.println(a);
        System.out.println(pattern.matcher(a).matches());
    }

    @Test
    public void readCsvFile() {
        String filePath = "F:\\upload\\test.csv";
        try {
            ArrayList<String[]> csvList = new ArrayList<String[]>();
            CsvReader reader = new CsvReader(filePath, ',', Charset.forName("GBK"));
            // reader.readHeaders();
            // 跳过表头,不跳可以注释掉
            while (reader.readRecord()) {
                csvList.add(reader.getValues());
                // 按行读取，并把每一行的数据添加到list集合
            }
            reader.close();
            System.out.println("读取的行数：" + csvList.size());
            for (int row = 0; row < csvList.size(); row++) {
                System.out.println("-----------------");
                //打印每一行的数据
                System.out.print(csvList.get(row)[0] + ",");
                System.out.println(csvList.get(row).length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void readCreate() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String line = "";
        while ((line = bf.readLine()) != null) {
            System.out.println("#{item." + line + "},");
        }
    }

    @Test
    public void createCsv() throws Exception{
        String[] newHeadData = {"PKIIB"};
        CsvWriter csvWriter = null;
        File writerFile = new File("F:/upload/test.csv");
        writerFile.createNewFile();
        csvWriter = new CsvWriter("F:/upload/test.csv", ',', Charset.forName("GBK"));
        //写头
        csvWriter.writeRecord(newHeadData);
        //写体
        String[] data = {"0100000010041"};
        csvWriter.writeRecord(data);
        csvWriter.close();
    }

}

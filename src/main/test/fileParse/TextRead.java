package fileParse;

import java.io.*;

public class TextRead {

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //读
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\jiuyuan4\\Desktop\\西安\\数据文件cvs\\content.txt"), "utf-8"));
            //写
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\jiuyuan4\\Desktop\\西安\\数据文件cvs\\filterContents.txt"), "utf-8"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                //.replaceAll("\n\t","")
                String chinese = filterChinese(line).trim();
                if (!"".equals(chinese)){
                    bufferedWriter.write(chinese);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    System.out.println(chinese);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String filterChinese(String chin)
    {
        chin = chin.replaceAll("[^(\\u4e00-\\u9fa5，。“”！￥‘’？)]", "");
        return chin;
    }


}

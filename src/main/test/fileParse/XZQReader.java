package fileParse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XZQReader {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\西安\\后台\\xzq.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String line = "";
        int count = 1;
        while ((line = bf.readLine()) != null) {
            System.out.println("INSERT INTO XZQ_MCDM (ID, XZQMC) VALUES(" + count + ",'" + line + "');");
            count ++;
        }
    }

}

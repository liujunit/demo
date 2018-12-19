package oracle;


import util.MD5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreateUpdate {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader("H:\\1.txt");
            bf = new BufferedReader(fr);
            String line = "";
            while ((line = bf.readLine()) != null) {
                String uuid = MD5.genUUID("gtzyt.shaanxi.gov.cn@" + line);
                System.out.println("update DIRECTORY_DATA set \"uuid\"='" + uuid + "' where \"pkiib\"='" + line + "';");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

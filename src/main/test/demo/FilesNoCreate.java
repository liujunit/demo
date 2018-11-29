package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilesNoCreate {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader("E:\\西安\\test.txt");
            bf = new BufferedReader(fr);
            String line = "";
            while ((line = bf.readLine()) != null) {
                if (line.length() == 1) {
                    System.out.println("000" + line);
                } else if (line.length() == 2) {
                    System.out.println("00" + line);
                } else if (line.length() == 3) {
                    System.out.println("0" + line);
                } else {
                    System.out.println("--------------------------------------" + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

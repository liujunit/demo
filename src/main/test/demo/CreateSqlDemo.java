package demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateSqlDemo {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\jiuyuan4\\Desktop\\time.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine())!=null) {
            System.out.println("insert into DIRECTORY_DATA (\"pkiib\") values ('"+ line +"');");
        }

    }

}

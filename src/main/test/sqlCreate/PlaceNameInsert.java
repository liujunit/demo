package sqlCreate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlaceNameInsert {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("E:\\西安\\目录数据dbf\\地名词.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int num = 1;
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            if (num > 30000) {
                System.out.println("INSERT INTO PLACE_NAME (ID, PLACE_NAME) VALUES ('" + num + "', '"+ line +"');");
            }
            if (num == 40000) {
                break;
            }
            num++;
        }
        bufferedReader.close();
        fileReader.close();
    }

}

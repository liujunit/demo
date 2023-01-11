package fileParse;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class JsonParse {

    public static void main(String[] args) throws FileNotFoundException {
        Set<String> files1 = new HashSet<>();
        try{

            // 需要读取的文件路径
            String path = "F:\\eve.json";
            File file = new File(path);
            // 判断文件是否存在
            if (file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineText = null;
                // 按行读取文件并打印,如果需要对内容进行操作可以在这里进行
                while((lineText = bufferedReader.readLine())!=null){
                    JSONObject jsonObject = JSONObject.parseObject(lineText);
                    if (jsonObject.containsKey("CIE_T")) {
                        JSONObject cie_t = jsonObject.getJSONObject("CIE_T");
                        JSONObject request = cie_t.getJSONObject("request");
                        JSONObject response = cie_t.getJSONObject("response");
                        Boolean file_storeQ = request.getBoolean("file_store");
                        Boolean file_storeS = response.getBoolean("file_store");
                        if (file_storeQ) {
                            String file_name = request.getString("file_name");
                            files1.add(file_name);
                        }
                        if (file_storeS) {
                            String file_name = response.getString("file_name");
                            files1.add(file_name);
                        }
                    }
                }
            }else{
                System.out.println("file doesn't exist");
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        Set<String> files2 = new HashSet<>();
        try{

            // 需要读取的文件路径
            String path = "F:\\aaa.txt";
            File file = new File(path);
            // 判断文件是否存在
            if (file.isFile() && file.exists()){
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineText = null;
                // 按行读取文件并打印,如果需要对内容进行操作可以在这里进行
                while((lineText = bufferedReader.readLine())!=null){
                    files2.add(lineText);
                }
            }else{
                System.out.println("file doesn't exist");
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        files1.removeAll(files2);
        for (String s : files1) {
            System.out.println(s);
        }
    }


}

package okhttp;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

public class VirustotalFileDemo {

    private static final String url = "https://www.virustotal.com/api/v3/files";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", "情报引擎接口说明(V1.0).docx",
                        RequestBody.create(MediaType.parse("multipart/form-data"), new File("F:\\情报引擎接口说明(V1.0).docx")))
//                .addPart(RequestBody.create(MediaType.parse("multipart/form-data"), new File("F:\\情报引擎接口说明(V1.0).docx")))
                .build();

        Request request = new Request.Builder()
                .header("x-apikey", "7e0cf8b25bfdfe1c3003e850955f161f4f347d4baeede170223c7302f5819e0e")
                .url(url)
                .post(requestBody)
                .build();

//        Response response = client.newCall(request).execute();
        final Call call = client.newCall(request);
        new Thread(() -> {
            try {
                Response response = call.execute();
                System.out.println(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

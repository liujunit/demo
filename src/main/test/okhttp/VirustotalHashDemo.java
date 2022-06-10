package okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class VirustotalHashDemo {

    private static final String url = "https://www.virustotal.com/api/v3/files/12b786e017bd0ff400e20327d582a03d2fbbae033b75d1c9747c524776d2bd53";

    private static final String url2 = "https://www.virustotal.com/api/v3/files/512301C535C88255C9A252FDF70B7A03";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .header("x-apikey", "abde72805640e56a41201885adb537f666b107ce333539076e93e34cba74e8e8")
                .url(url)
                .build();

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

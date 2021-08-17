package okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class VirustotalDemo {

    private static final String url1 = "https://www.virustotal.com/api/v3/domains/andisec.com";

    private static final String url2 = "https://www.virustotal.com/api/v3/ip_addresses/1.1.1.1";

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080)))
                .build();
        final Request request = new Request.Builder()
                .header("x-apikey", "7e0cf8b25bfdfe1c3003e850955f161f4f347d4baeede170223c7302f5819e0e")
                .url(url2)
                .build();
        final Call call = okHttpClient.newCall(request);
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

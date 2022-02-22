package okhttp;

import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * 不需要代理也可以，只提供了IP搜索
 */
public class CensysDemo {

    private static final String url1 = "https://search.censys.io/api/v2/hosts/8.8.8.8";

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .authenticator((route, response) -> {
                    //认证
                    String credential = Credentials.basic("5e9db3ce-21ea-42db-a86b-6a71714f1b77", "xSwL7Wtnvmd6Z1NOplwpcLa5rghOKonI");
                    return response.request().newBuilder().header("Authorization", credential).build();
                })
                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080)))
                .build();
        final Request request = new Request.Builder()
                .url(url1)
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

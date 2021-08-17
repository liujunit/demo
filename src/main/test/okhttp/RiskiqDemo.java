package okhttp;

import okhttp3.*;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class RiskiqDemo {


    private static final String url1 = "https://api.riskiq.net/pt/v2/dns/passive?query=8.8.8.8";

    private static final String auth = "2969192546@qq.com:73fa908881ba24078a6d3b32e565bc9362538d3a07eb6d50a7e4599f21c3c82f";

    public static void main(String[] args) throws UnsupportedEncodingException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .authenticator((route, response) -> {
//                    //认证
//                    String credential = Credentials.basic("andisec-riskiq-key", "andisec-riskiq-secret");
//                    return response.request().newBuilder().header("Authorization", credential).build();
//                })
//                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080)))
                .build();
        byte[] authEncBytes = Base64.encodeBase64(auth.getBytes("utf-8"));
        String authStringEnc = new String(authEncBytes);
        final Request request = new Request.Builder()
                .header("Authorization", " Basic " + authStringEnc)
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

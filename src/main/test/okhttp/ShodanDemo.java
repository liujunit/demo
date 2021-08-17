package okhttp;

import okhttp3.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * 需要代理
 */
public class ShodanDemo {
    /**

     {"region_code": "22", "tags": [], "ip": 3057502215, "area_code": null, "domains": [], "hostnames": [], "postal_code": null, "dma_code": null, "country_code": "CN", "org": "Beijing Baidu Netcom Science and Technology Co., Ltd.", "data": [], "asn": "AS38365", "city": "Beijing", "latitude": 39.9075, "isp": "Beijing Baidu Netcom Science and Technology Co., Ltd.", "longitude": 116.39723, "last_update": "2021-07-21T06:32:52.409895", "country_code3": null, "country_name": "China", "ip_str": "182.61.200.7", "os": null, "ports": [80, 443]}

     */

    private static final String url1 = "https://api.shodan.io/shodan/host/182.61.200.7?key=6AEZ2xn9mXOPVEarxFO5mQp3VtvQcRm5&minify=false";

    //host收费
    private static final String url2 = "https://api.shodan.io/dns/domain/www.baidu.com?key=CohV6K94CvSDB35U34FFd9RVQSAEIirK&minify=false";

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//                .proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 1080)))
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

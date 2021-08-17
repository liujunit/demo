package okhttp;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.whois.WhoisClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 不需要代理，貌似只能分析IP
 */
public class WhoisDemo {

    public static void main(String[] args) throws IOException {
        final WhoisClient whoisClient = new WhoisClient();
        whoisClient.setDefaultPort(43);
        whoisClient.setConnectTimeout(10000);
        whoisClient.setDefaultTimeout(10000);
        whoisClient.connect("whois.afrinic.net");
//        whoisClient.connect("whois.apnic.net");
//        whoisClient.connect("whois.arin.net"); //需要n+
//        whoisClient.connect("whois.lacnic.net");
//        whoisClient.connect("whois.ripe.net");
        List<String> list = IOUtils.readLines(whoisClient.getInputStream("182.61.200.7"), StandardCharsets.UTF_8);
        list.forEach(e -> System.out.println(e));
        whoisClient.disconnect();
    }

}

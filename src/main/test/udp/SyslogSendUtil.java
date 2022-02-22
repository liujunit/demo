package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * graylog 数据发送工具类
 */
public class SyslogSendUtil {

    /**
     * syslog udp 发送
     * @param data
     * @throws IOException
     */
    public static void sendSyslog(String data) throws IOException, InterruptedException {
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 514);
        //发送
        datagramSocket.send(datagramPacket);
        System.out.println("发送--->" + data);
        datagramSocket.close();
        Thread.sleep(2000);
    }

}

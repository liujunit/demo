package udp;

import util.UuidUtil;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GrayLogUdp {

    public static void main(String[] args) {
        try {
            int i = 1;
            while (true) {
                DatagramSocket datagramSocket = new DatagramSocket();
                String id = UuidUtil.get32UUID();
                String data = "{id:'" + id + "',name:'UdpName" + i + "',''messages:'发送消息哈哈哈哈哈！'}";
                DatagramPacket datagramPacket = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 5555);
                //发送
                datagramSocket.send(datagramPacket);
                System.out.println("已发送……");
                datagramSocket.close();
                Thread.sleep(2000);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

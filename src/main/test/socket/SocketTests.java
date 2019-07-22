package socket;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTests {

    @Test
    public void test01() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostAddress = inetAddress.getHostAddress();
            System.out.println(hostAddress);
            String hostName = inetAddress.getHostName();
            System.out.println(hostName);
            InetAddress byName = InetAddress.getByName("192.168.0.116");
            System.out.println(byName.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(10080);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes)) != -1) {
            System.out.println("服务端：" + new String(bytes, 0 ,len));
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hh".getBytes());
        outputStream.flush();
        outputStream.close();
        is.close();
        accept.close();
        serverSocket.close();
    }

    @Test
    public void test03() throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 10080);
        OutputStream outputStream = socket.getOutputStream();
        String message = "来了老弟";
        outputStream.write(message.getBytes());
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        outputStream.close();
        socket.close();
    }

}

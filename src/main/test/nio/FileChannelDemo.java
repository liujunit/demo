package nio;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    @Test
    public void test01() {
        RandomAccessFile rafFile = null;
        try {
            rafFile = new RandomAccessFile("D:\\个人文档区\\ZL\\test.txt", "rw");
            FileChannel channel = rafFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = channel.read(byteBuffer);
            System.out.println(read);
            while (read != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.println(new String(String.valueOf((char)byteBuffer.get()).getBytes(), "utf-8"));
                }
                byteBuffer.compact();
                read = channel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                rafFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

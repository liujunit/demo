package zip;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ZipDemo {

    /**
     * zip解压缩测试
     */
    @Test
    public void test01() {
        String s = "Hello World!";
        byte[] bytes = s.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String s2 = "Hello World!2";
        byte[] bytes2 = s2.getBytes();
        InputStream inputStream2 = new ByteArrayInputStream(bytes2);
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setFileNameInZip("测试.txt");
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
            ZipFile zipFile = new ZipFile("D:\\aaaa.zip", "123456".toCharArray());
            zipFile.addStream(inputStream, zipParameters);
            ZipParameters zipParameters2 = new ZipParameters();
            zipParameters2.setFileNameInZip("测试2.txt");
            zipParameters2.setEncryptFiles(true);
            zipParameters2.setEncryptionMethod(EncryptionMethod.AES);
            // Below line is optional. AES 256 is used by default. You can override it to use AES 128. AES 192 is supported only for extracting.
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
            zipFile.addStream(inputStream2, zipParameters2);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    /**
     * zip解压缩测试
     */
    @Test
    public void test02() {
        String s = "Hello World!";
        byte[] bytes = s.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        String s2 = "Hello World!2";
        byte[] bytes2 = s2.getBytes();
        InputStream inputStream2 = new ByteArrayInputStream(bytes2);
        try {
            ZipParameters zipParameters = new ZipParameters();
            zipParameters.setFileNameInZip("测试.txt");
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.AES);
            // Below line is optional. AES 256 is used by default. You can override it to use AES 128. AES 192 is supported only for extracting.
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            zipInputStream.setPassword("123456".toCharArray());




            ZipFile zipFile = new ZipFile("D:\\aaaa.zip", "123456".toCharArray());
            zipFile.addStream(inputStream, zipParameters);
            ZipParameters zipParameters2 = new ZipParameters();
            zipParameters2.setFileNameInZip("测试2.txt");
            zipParameters2.setEncryptFiles(true);
            zipParameters2.setEncryptionMethod(EncryptionMethod.AES);
            // Below line is optional. AES 256 is used by default. You can override it to use AES 128. AES 192 is supported only for extracting.
            zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
            zipFile.addStream(inputStream2, zipParameters2);

        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

}

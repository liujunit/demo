package base64;


import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class Demo01 {

    /**
     * ipv4
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test01() throws UnsupportedEncodingException {
        String base64 = "BADAqAEBwKgBAsCoAQPAqAEE";
        byte[] bytes = Base64.getDecoder().decode(base64);
//        byte[] bytes = base64.getBytes(StandardCharsets.UTF_8);
        byte[] countB = new byte[1];
        byte[] typeB = new byte[1];
        byte[] contentB = new byte[bytes.length - 2];
        System.arraycopy(bytes, 0, countB, 0, 1);
        System.arraycopy(bytes, 1, typeB, 0, 1);
        System.arraycopy(bytes, 2, contentB, 0, contentB.length);
        System.out.println(countB[0]);
        System.out.println(typeB[0]);

        System.out.println("=========================");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < contentB.length; i++) {
            Integer integer = Integer.valueOf(contentB[i]);
            if (integer < 0) {
                integer += 256;
            }
            result.append(integer);
            if (i != (contentB.length - 1)) {
                if ((i + 1) % 4 == 0 && i != 0) {
                    result.append(",");
                } else {
                    result.append(".");
                }
            }
        }
        System.out.println(result);
    }


    /**
     * ipv6
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test02() throws UnsupportedEncodingException {
        String base64 = "AgL+gAAAAAAAAAAAAAD71nhg/oAAAAAAAAACG3f/+9Z4YA==";
        byte[] bytes = Base64.getDecoder().decode(base64);
//        byte[] bytes = base64.getBytes(StandardCharsets.UTF_8);
        byte[] countB = new byte[1];
        byte[] typeB = new byte[1];
        byte[] contentB = new byte[bytes.length - 2];
        System.arraycopy(bytes, 0, countB, 0, 1);
        System.arraycopy(bytes, 1, typeB, 0, 1);
        System.arraycopy(bytes, 2, contentB, 0, contentB.length);
        System.out.println(countB[0]);
        System.out.println(typeB[0]);

        System.out.println("=========================");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < contentB.length; i++) {
            Integer integer = Integer.valueOf(contentB[i]);
            if (integer < 0) {
                integer += 256;
            }
            String hex = Integer.toHexString(integer);
            result.append(String.join("", Collections.nCopies(2 - hex.length(), "0")));
            result.append(hex);
            if (i != (contentB.length - 1)) {
                if ((i + 1) % 16 == 0 && i != 0) {
                    result.append(",");
                } else if ((i + 1) % 2 == 0){
                    result.append(":");
                }
            }
        }
//        String[] resultSplit = result.toString().split(",");
//        StringBuffer formatResult = new StringBuffer();
//        for (int i = 0; i < resultSplit.length; i++) {
//            String s = resultSplit[i];
//            String[] split1 = s.split(":");
//            for (int j = 0; j < split1.length; j++) {
//                String s1 = split1[j];
//                formatResult.append(String.join("", Collections.nCopies(4 - s1.length(), "0")));
//                formatResult.append(s1);
//                if (j != split1.length - 1) {
//                    formatResult.append(":");
//                }
//            }
//            if (i != resultSplit.length - 1) {
//                formatResult.append(",");
//            }
//        }
        System.out.println(result.toString());

    }


    /**
     * mac
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test03() throws UnsupportedEncodingException {
        String base64 = "AwMAESIzRFUAAAAAABH///////8=";
        byte[] bytes = Base64.getDecoder().decode(base64);
//        byte[] bytes = base64.getBytes(StandardCharsets.UTF_8);
        byte[] countB = new byte[1];
        byte[] typeB = new byte[1];
        byte[] contentB = new byte[bytes.length - 2];
        System.arraycopy(bytes, 0, countB, 0, 1);
        System.arraycopy(bytes, 1, typeB, 0, 1);
        System.arraycopy(bytes, 2, contentB, 0, contentB.length);
        System.out.println(countB[0]);
        System.out.println(typeB[0]);

        System.out.println("=========================");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < contentB.length; i++) {
            Integer integer = Integer.valueOf(contentB[i]);
            if (integer < 0) {
                integer += 256;
            }
            String hex = Integer.toHexString(integer);
            result.append(String.join("", Collections.nCopies(2 - hex.length(), "0")));
            result.append(hex);
            if (i != (contentB.length - 1)) {
                if ((i + 1) % 6 == 0 && i != 0) {
                    result.append(",");
                } else {
                    result.append(":");
                }
            }
        }
//        String[] resultSplit = result.toString().split(",");
//        StringBuffer formatResult = new StringBuffer();
//        for (int i = 0; i < resultSplit.length; i++) {
//            String s = resultSplit[i];
//            String[] split1 = s.split(":");
//            for (int j = 0; j < split1.length; j++) {
//                String s1 = split1[j];
//                formatResult.append(String.join("", Collections.nCopies(4 - s1.length(), "0")));
//                formatResult.append(s1);
//                if (j != split1.length - 1) {
//                    formatResult.append(":");
//                }
//            }
//            if (i != resultSplit.length - 1) {
//                formatResult.append(",");
//            }
//        }
        System.out.println(result.toString());

    }

}

package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 说明：MD5处理
 * 创建人：FH Q313596790
 * 修改时间：2014年9月20日
 * @version
 */
public class MD5 {

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}

	public static String genUUID(String rootCode) {
		if (rootCode == null || rootCode.isEmpty()) {
			throw new java.lang.IllegalArgumentException();
		}
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			byte[] bd = rootCode.toLowerCase().getBytes();
			m.update(bd);
			StringBuilder sb = new StringBuilder();
			int offset = 0;
			byte[] md = m.digest();
			for (byte b : md) {
				sb.append(String.format("%02x", b & 0xff));
				if (offset == 3 || offset == 5 || offset == 7 || offset == 9)
					sb.append("-");
				offset++;
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(md5("31119@qq.com"+"123456"));
		System.out.println(md5("mj1"));
	}
}

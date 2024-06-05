
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptado {

	public static String getMD5(final String input) {
		try {
			final MessageDigest md = MessageDigest.getInstance("MD5");
			final byte[] messageDigest = md.digest(input.getBytes());
			final StringBuilder sb = new StringBuilder();
			for (final byte b : messageDigest)
				sb.append(String.format("%02x", b));
			return sb.toString();
		} catch (final NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}

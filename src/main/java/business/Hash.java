package business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	public static String makeHash(String password) {
		try {
			MessageDigest msg = MessageDigest.getInstance("SHA");
			msg.update(password.getBytes());
			
			byte[] resultByteArray = msg.digest();
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b : resultByteArray) {
				sb.append(String.format("%02x", b));
			}
			
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
}

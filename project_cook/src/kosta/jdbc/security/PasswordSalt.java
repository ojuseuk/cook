package kosta.jdbc.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordSalt {
	
	public static byte[] excute(byte[] password){
		
		MessageDigest messageDigest = null;
		byte[] salt = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-1");
			byte[] seed = messageDigest.digest(password);
			
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
			
			salt = new byte[32];
			secureRandom.nextBytes(salt);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salt;
		
	}
}

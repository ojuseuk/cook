package kosta.jdbc.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SecurityKey {

	public static SecretKey excute(char[] password, byte[] salt){
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, 1000, 128);
		SecretKeyFactory sf =null;
		SecretKey securityKey = null;
		try {
			sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			securityKey = sf.generateSecret(keySpec);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return securityKey;
		
	}

	
} // end of class

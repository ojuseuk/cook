package kosta.jdbc.security;

import java.util.Base64;

public class Encoding {
	
	public static byte[] excute(byte[] bytes){
		Base64.Encoder e = Base64.getEncoder();
		byte[] encoderbyte = e.encode(bytes);
		return encoderbyte;
	}
}

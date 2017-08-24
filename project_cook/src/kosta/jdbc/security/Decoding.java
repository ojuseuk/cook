package kosta.jdbc.security;

import java.util.Base64;

public class Decoding {

	public static byte[] excute(byte[] pwd){
		Base64.Decoder d = Base64.getDecoder();
		System.out.println("decoding: " + pwd);
//		byte[] a=Conversion.fromHex(pwd);
		byte[] decodeByte = d.decode(pwd);
		
		
		
		return decodeByte;
	}
	
}

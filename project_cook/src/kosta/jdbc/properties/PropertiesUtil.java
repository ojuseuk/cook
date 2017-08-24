package kosta.jdbc.properties;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties prop;
	static {
		prop = new Properties();
		
		try (FileInputStream fis = new FileInputStream("cook.properties")) {
			prop.load(fis);
			
		} catch(Exception e) {
			
		}
	}
	public static String get(String key) {
		
		return (String) prop.get(key);
	}
}

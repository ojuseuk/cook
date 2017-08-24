package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import kosta.jdbc.dto.Guest;
import kosta.jdbc.security.Conversion;
import kosta.jdbc.security.Decoding;
import kosta.jdbc.security.PasswordSalt;
import kosta.jdbc.security.SecurityKey;
import kosta.jdbc.util.DBUtil;

public class GuestDao {
	public static int signUp(Guest g) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into guest values(?, ?, ?, ?, ?, ?, ?, ?)";
//		pbkdf2
		byte[] salt = PasswordSalt.excute(g.getGuestPwd().getBytes());
		
		SecretKey secretKeykey = SecurityKey.excute(g.getGuestPwd().toCharArray(), salt);

		String guestSalt=Conversion.toHex(salt);
		String guestKey=Conversion.toHex(secretKeykey.getEncoded());
		
//		base64
//		byte[] c =Encoding.excute(guestPwd.getBytes());
//		String d =Conversion.toHex(c);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, g.getGuestId());
			pstmt.setString(2, g.getGuestPwd());
			pstmt.setString(3, g.getGuestName());
			pstmt.setString(4, g.getGuestState());
			pstmt.setString(5, g.getGuestCity());
			pstmt.setInt(6, g.getGuestMoney());
			pstmt.setString(7, guestSalt);
			pstmt.setString(8, guestKey);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	
	public static String logIn(String guestId, String guestPwd) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select guest_pwd, guest_salt, guest_key from guest where guest_id = ?";
		String s = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestId);
			result = pstmt.executeQuery();
			
			s = "아이디가 올바르지 않습니다";
			
			while (result.next()) {
				String guestSalt = result.getString("guest_salt");
				
				byte[] pwd = Conversion.fromHex(guestSalt);
//				pbkdf2				
//				System.out.println(guestSalt);
				SecretKey secretKeykey = SecurityKey.excute(guestPwd.toCharArray(), pwd);

				String key = Conversion.toHex(secretKeykey.getEncoded());
				String guestKey = result.getString("guest_key");
//				System.out.println(guestKey);
//				System.out.println(key);
				
//				base64
//				byte[] c = Decoding.excute(pwd);
//				String e = new String(c);
//				System.out.println(e);
				
				if (!guestKey.equals(key)) {
					s = "비밀번호가 올바르지 않습니다";
				} else {
					s = "로그인 성공";
					break;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return s;
	}
	
	public static Map<String, String> guestCitySearch(String guestId) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select guest_state, guest_city from guest where guest_id = ?";
		
		Map<String, String> map = new HashMap<>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestId);
			
			result  = pstmt.executeQuery();
			
			while (result.next()) {
				map.put(result.getString("guest_state"), result.getString("guest_city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return map;
	}

}

package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.jdbc.dto.Guest;
import kosta.jdbc.util.DBUtil;

public class GuestDao {
	public static int signUp(Guest g) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into guest values(?, ?, ?, ?, ?, ?)";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, g.getGuestId());
			pstmt.setInt(2, g.getGuestPwd());
			pstmt.setString(3, g.getGuestName());
			pstmt.setString(4, g.getGuestState());
			pstmt.setString(5, g.getGuestCity());
			pstmt.setInt(6, g.getGuestMoney());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		return result;
	}
	
	public static String logIn(String guestId, int guestPwd) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select guest_pwd from guest where guest_id = ?";
		String s = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestId);
			result = pstmt.executeQuery();
			
			s = "아이디가 올바르지 않습니다";
			
			while (result.next()) {
				int guestPwd_sql = result.getInt("guest_pwd");
				
				if (guestPwd != guestPwd_sql) {
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

}

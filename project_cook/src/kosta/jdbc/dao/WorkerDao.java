package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kosta.jdbc.dto.Menu;
import kosta.jdbc.util.DBUtil;

public class WorkerDao {
	
	public static int menuInsert(Menu menu){
		Connection con = DBUtil.getConnection();
		
		String sql = "INSERT INTO menu VALUES(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(menu.toString());
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, menu.getMenuNum());
			pstmt.setInt(2, menu.getCookNum());
			pstmt.setString(3, menu.getMenuName());
			pstmt.setInt(4, menu.getMenuPrice());
			pstmt.setInt(5, menu.getMenuFirst());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return result;
	} // end of menuInsert
} // end of class

package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.jdbc.dto.Menu;
import kosta.jdbc.util.DBUtil;

public class MenuDao {

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
	
	public static int menuDelete(int menuNum){
		Connection con = DBUtil.getConnection();
		
		String sql = "delete from menu where menu_num = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, menuNum);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return result;
	} // end of MenuDelete
	
	public static List<Menu> menuList(int cookNum) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Menu> list = new ArrayList<>();
		
		String sql = "select * from menu where cook_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cookNum);
			
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Menu m = new Menu(result.getInt("menu_num"), result.getString("menu_name"), result.getInt("menu_price"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}

package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kosta.jdbc.dto.Cook;
import kosta.jdbc.util.DBUtil;

public class CookDao {
	public static List<Cook> cookList() {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Cook> list = new ArrayList<>();
		
		String sql = "select * from cook order by cook_num";
		
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeQuery();
			
			while (result.next()) {
				Cook c = new Cook(result.getInt("cook_num"), result.getString("cook_name"), result.getString("cook_type"), result.getString("cook_state"), result.getString("cook_city"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public static Map<String, String> cookCitySearch(int num) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String sql = "select cook_state, cook_city from cook where cook_num = ?";
		
		Map<String, String> map = new HashMap<>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result  = pstmt.executeQuery();
			
			while (result.next()) {
				map.put(result.getString("cook_state"), result.getString("cook_city"));
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

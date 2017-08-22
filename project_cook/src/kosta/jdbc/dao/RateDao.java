package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kosta.jdbc.dto.Rate;
import kosta.jdbc.util.DBUtil;
import oracle.net.aso.f;

public class RateDao {
	
	public static int ratePurchase(int menuNum, int cookNum, int ratePrice, String guestId){
		Connection con = DBUtil.getConnection();
		
		System.out.println("2:" + menuNum + " " + " " + cookNum + " " + ratePrice);
		String sql = "insert into rate(rate_num, guest_id, menu_num, cook_num, rate_price, rate_day)"
				+ "values(rate_seq.nextval, ?, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestId);
			pstmt.setInt(2, menuNum);
			pstmt.setInt(3, cookNum);
			pstmt.setInt(4, ratePrice);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return result;
		
	}// end of ratePurchase 
	
	public static List<Rate> rateListView(String guestId){
		Connection con = DBUtil.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT r.rate_num, c.cook_name, m.menu_name, r.guest_id, r.rate_price, r.rate_day, r.rate_num "
				+ "FROM rate R, menu M, cook C WHERE R.menu_num = M.menu_num "
				+ "AND M.cook_num = C.cook_num "
				+ "and r.guest_id = ?";
		
		List<Rate> list = new ArrayList<>();
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, guestId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Rate rate = new Rate();
				
				rate.setRate_num(rs.getInt("rate_num"));
				rate.setCook_name(rs.getString("cook_name"));
				rate.setMenu_name(rs.getString("menu_name"));
				rate.setGuest_id(rs.getString("guest_id"));
				rate.setRatePirce(rs.getInt("rate_price"));
				rate.setRate_day(rs.getDate("rate_day"));
				rate.setRate_num(rs.getInt("rate_num"));
				
				list.add(rate);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return list;
		
	}// end of rateListView
}

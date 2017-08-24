package kosta.jdbc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.w3c.dom.stylesheets.LinkStyle;

import kosta.jdbc.dto.Rate;
import kosta.jdbc.dto.Worker;
import kosta.jdbc.util.DBUtil;
import oracle.net.aso.f;

public class RateDao {
	
	public static int ratePurchase(int menuNum, int cookNum, int ratePrice, String guestId, int rateMargin){
		Connection con = DBUtil.getConnection();
		
		String sql = "{call menu_insert_proc(?, ?, ?, ?, ?, sysdate-2, ?)}";
		CallableStatement cstmt = null;
		int result = 0;
		int rs = 0;
		
		try {
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, menuNum);
			cstmt.setInt(2, cookNum);
			cstmt.setInt(3, ratePrice);
			cstmt.setString(4, guestId);
			cstmt.setInt(5, rateMargin);
			
			cstmt.registerOutParameter(6, Types.INTEGER);
			
			rs = cstmt.executeUpdate();
			
			result = cstmt.getInt(6);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(cstmt, con);
		}
		
		return result;
		
	}// end of ratePurchase 
	
	public static List<Rate> rateListView(String guestId){
		Connection con = DBUtil.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT r.rate_num, c.cook_name, m.menu_name, r.guest_id, r.rate_price, r.rate_day, r.rate_num, r.cook_num "
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
				rate.setCook_num(rs.getInt("cook_num"));
				
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
	
	public static int rateEvaluation(int rateGrade, String rateReview, String rateWorkerName, int rateNum){
		
		Connection con = DBUtil.getConnection();
		CallableStatement cstmt = null;
		String sql = "{call rate_insert_proc(?, ?, ?, ?, ?)}";
		int result = 0;
		int rs = 0;
		
		try {
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, rateNum);
			cstmt.setInt(2, rateGrade);
			cstmt.setString(3, rateReview);
			cstmt.setString(4, rateWorkerName);
			cstmt.registerOutParameter(5, Types.INTEGER);

			result = cstmt.executeUpdate();
			
			rs = cstmt.getInt(5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(cstmt, con);
		}
		
		return rs;
		
	} // end of rateEvaluation	
	
	
	public static List<Worker> workerView(int cookNum){
		Connection con = DBUtil.getConnection();
		
		String sql = "SELECT worker_name FROM worker where cook_num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Worker> list = new ArrayList<>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cookNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Worker worker = new Worker();
				
				worker.setWorkerName(rs.getString("worker_name"));
				
				list.add(worker);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
}

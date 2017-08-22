package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.stylesheets.LinkStyle;

import kosta.jdbc.dto.Menu;
import kosta.jdbc.dto.Profit;
import kosta.jdbc.dto.Worker;
import kosta.jdbc.util.DBUtil;

public class WorkerDao {
	
	public static int workerSignUp(Worker worker){
		Connection con = DBUtil.getConnection();
		
		String sql = "INSERT INTO worker(worker_num, cook_num, worker_name, worker_sales) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, worker.getWorkerNum());
			pstmt.setInt(2, worker.getCookNum());
			pstmt.setString(3, worker.getWorkerName());
			pstmt.setInt(4, worker.getWorkerSales());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt, con);
		}
		
		return result;
		
	}// end of workerSignUp
	
	public static Map<Integer, Integer> workerLogin(int worker_num){
		Connection con = DBUtil.getConnection();
		
		String sql="select worker_num, cook_num from worker where worker_num = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> map = new HashMap<>();
		
		int workerNum = 0;
		int cookNum = 0;
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, worker_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				workerNum = rs.getInt("worker_num");
				cookNum = rs.getInt("cook_num");
				
				map.put(workerNum, cookNum);
			}
//			System.out.println(workerNum + "|" + cookNum);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return map;
		
	} // end of workerLogin
	
	public static List<Profit> profitCheck(int workerNum){
		Connection con = DBUtil.getConnection();
			
		String sql = "SELECT c.cook_name, profit_sales, profit_margin, profit_day "
				+ "FROM profit P, cook c "
				+ "where p.cook_num = c.cook_num and c.cook_num = (select cook_num from worker where worker_num = ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Profit> list = new ArrayList<>();
//		Map<String, List<Profit>> map = new HashMap<>();
		
		try {
//			System.out.println(workerNum);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, workerNum);

			rs=pstmt.executeQuery();

			String cookName = null;
			while(rs.next()){
				Profit profit = new Profit();
				
				profit.setProfitSales(rs.getInt("profit_sales"));
				profit.setProfitMargin(rs.getInt("profit_margin"));
				profit.setProfitDay(rs.getDate("profit_day"));
				profit.setCookName(rs.getString("cook_name"));
//				cookName = rs.getString("cook_name");
				list.add(profit);
			
			}
			
//			map.put(cookName, list);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return list;
				
	} // end of profitCheck
	
	public static Map<Integer, Date> profitMonthCheck(int workerNum){
		Connection con = DBUtil.getConnection();
			
		String sql = "select sum(profit_sales) sum, to_char(profit_day, 'MM') m from profit where cook_num = ? group by to_char(profit_day, 'MM');";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		List<Profit> list = new ArrayList<>();
		Map<Integer, Date> map = new HashMap<>();
		
		try {
//			System.out.println(workerNum);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, workerNum);
			
			rs  =pstmt.executeQuery();
			
			String cookName = null;
			while(rs.next()){
//				System.out.println(rs.getInt("sum"));
//				System.out.println(rs.getDate("m"));
				map.put(rs.getInt("sum"), rs.getDate("m"));
				
//				Profit profit = new Profit();
//				profit.setProfitSales(rs.getInt("sum"));
//				System.out.println(rs.getInt("sum"));
//				profit.setProfitMargin(rs.getInt("profit_margin"));
//				profit.setProfitDay(rs.getDate("m"));
//				System.out.println(rs.getDate("m"));
//				profit.setCookName(rs.getString("cook_name"));
//				list.add(profit);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return map;
				
	} // end of profitMonthCheck
	
	public static List<Profit> marginMonthCheck(int workerNum){
		return null;
	
	} // end of marginMonthCheck
	
	
} // end of class

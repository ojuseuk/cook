package kosta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosta.jdbc.dto.Menu;
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
	
	public static int workerLogin(int worker_num){
		Connection con = DBUtil.getConnection();
		
		String sql="select worker_num from worker where worker_num = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int workerNum = 0;	//
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, workerNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				workerNum = worker_num;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, con);
		}
		
		return worker_num;
		
	}
	
	
} // end of class

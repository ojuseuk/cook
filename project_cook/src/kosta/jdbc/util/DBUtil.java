package kosta.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String DRIVER_NAME="oracle.jdbc.driver.OracleDriver";
	private static final String CON_URL="jdbc:oracle:thin:@192.168.0.114:1521:xe";
	private static final String USER_NAME = "cook";
	private static final String PASSWORD = "1234";
	
	// 클래스 로드 할때 한번만 실행 된다.
	// 1. JDBC 드라이버 로드
	static {
		try {
			Class.forName(DRIVER_NAME);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 리펙토링
	// 2. DB 서버 연결
	public static Connection getConnection(){
		Connection con = null;
		try {
			
			con = DriverManager.getConnection(CON_URL, USER_NAME, PASSWORD);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	// 6. 자원 사용 종료
	public static void close(PreparedStatement pstmt, Connection con){
		try {
			if(pstmt !=null)pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs != null) rs.close();
			if(pstmt !=null)pstmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

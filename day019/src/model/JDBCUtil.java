package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// 다양한 DAO에서
//  연결(), 해제() 를 사용할 예정
//   => 별도의 Util 클래스로 '모듈화'
public class JDBCUtil {
	
	static final String driverName="oracle.jdbc.driver.OracleDriver";
	static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	static final String user="teemo";
	static final String passwd="1234";
	
	public static Connection connect() {
		Connection conn=null;
		
		try {
			// 1. driver를 메모리에 로드 == 적재
			Class.forName(driverName);
			
			// 2. conn 객체를 확보
			conn=DriverManager.getConnection(url,user,passwd);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			// 4. 연결 해제
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

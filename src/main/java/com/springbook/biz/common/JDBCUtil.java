package com.springbook.biz.common;

import java.sql.*;

public class JDBCUtil {

	public static Connection GetConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("DB 연결 완료");
			
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB연결 오류");
		}

		return null;
	}

	public static void close(PreparedStatement pstmt, Connection conn) {
	      if(pstmt != null) {
	         try {
	            if(!pstmt.isClosed()) pstmt.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            pstmt = null;
	         }
	      }
	      if(conn != null) {
	         try {
	            if(!conn.isClosed()) conn.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            conn = null;
	         }
	      }
	   }
	   public static void close(ResultSet rs,PreparedStatement pstmt, Connection conn) {
	      if(rs != null) {
	         try {
	            if(!rs.isClosed()) rs.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            rs = null;
	         }
	      }
	      if(pstmt != null) {
	         try {
	            if(!pstmt.isClosed()) pstmt.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            pstmt = null;
	         }
	      }
	      if(conn != null) {
	         try {
	            if(!conn.isClosed()) conn.close();
	         } catch (Exception e) {
	            e.printStackTrace();
	         } finally {
	            conn = null;
	         }
	      }
	   }
}

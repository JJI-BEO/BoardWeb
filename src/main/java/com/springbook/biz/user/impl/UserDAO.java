package com.springbook.biz.user.impl;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;

@Repository
public class UserDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//회원정보 검색
	public UserVO getUser(UserVO vo) {
	     
		UserVO user = null;

		String USER_GET = "select * from users where id=? and password=?";
		
		try {
			conn = JDBCUtil.GetConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();

			 if (rs.next()) {
				 user = new UserVO();
				 user.setId(rs.getString("id"));
				 user.setPassword(rs.getString("password"));
				 user.setName(rs.getString("name"));
				 user.setRole(rs.getString("role"));
				 System.out.println("1명정보 : " + user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		
	      return user;   
	   }
}

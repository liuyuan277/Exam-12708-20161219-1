package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.UserDao;
import com.hand.entity.Customer;
import com.hand.jdbc.ConnectionFactory;


public class CheckUserService {
    private UserDao dao=new UserDao();
	
	public boolean check(Customer user){
		Connection conn = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=dao.get(conn, user);
			
			while (rs.next()) {
				System.out.println(rs.getString("first_name"));
				return true;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}

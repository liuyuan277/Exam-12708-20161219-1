package com.hand.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;
import com.hand.jdbc.ConnectionFactory;

public class UpdateFilmService {
	
	 private FilmDao dao=new FilmDao();
		
		public void update(Film film){
			Connection conn = null;
			
			try {
				conn=ConnectionFactory.getInstance().getConnection();
				conn.setAutoCommit(false);
				
				 dao.update(conn,film);
				 conn.commit();

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
		}
}

package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hand.dao.FilmDao;
import com.hand.entity.Film;
import com.hand.jdbc.ConnectionFactory;

public class SelectFilmService {
    private  FilmDao dao=new FilmDao();
	
	public   ArrayList select(){
		ArrayList<Film> list=new ArrayList();
		Connection conn = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=dao.get(conn);
			
			while (rs.next()) {
				Film film=new Film();
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage(rs.getString("name"));
				film.setLanguage_id(rs.getInt("language_id"));
				
				list.add(film);
			}
			return list;
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
		
		return list;
	}
	
	public Film selectFilm(Film film){
		Film film1=null;
		Connection conn = null;
		try {
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			ResultSet rs=dao.getFile(conn,film);
			
			if (rs.next()) {
				film1=new Film();
				film1.setFilm_id(rs.getInt("film_id"));
				film1.setTitle(rs.getString("title"));
				film1.setDescription(rs.getString("description"));
				film1.setLanguage(rs.getString("name"));
				film.setLanguage_id(rs.getInt("language_id"));
			}
			return film1;
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
		
		return film1;
	}
}

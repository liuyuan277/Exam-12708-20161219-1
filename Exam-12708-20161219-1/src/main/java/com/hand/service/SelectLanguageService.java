package com.hand.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.hand.dao.LanguageDao;
import com.hand.entity.Language;
import com.hand.jdbc.ConnectionFactory;

public class SelectLanguageService {
	  private static LanguageDao dao=new LanguageDao();
		
		public static ArrayList<Language> select(){
			ArrayList<Language> list=new ArrayList<Language>();
			Connection conn = null;
			try {
				conn=ConnectionFactory.getInstance().getConnection();
				conn.setAutoCommit(false);
				
				ResultSet rs=dao.get(conn);
				
				while (rs.next()) {
					Language language=new Language();
					language.setName(rs.getString("name"));
					language.setLanguage_id(rs.getInt("language_id"));
					list.add(language);
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
}

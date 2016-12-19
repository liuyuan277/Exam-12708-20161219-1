package com.hand.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageDao {
	public ResultSet get(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select * from language");
		return ps.executeQuery();
	}
}

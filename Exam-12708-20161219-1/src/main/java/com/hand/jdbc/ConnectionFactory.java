package com.hand.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory=new ConnectionFactory();
	private Connection conn;
	
	static{
		Properties pro=new Properties();
		try {
			InputStream in=ConnectionFactory.class.getClassLoader()
					              .getResourceAsStream("dbconfig.properties");
			pro.load(in);
		} catch (IOException e) {
			System.out.println("读取配置文件错误");
		}
		
		driver=pro.getProperty("driver");
		dburl=pro.getProperty("dburl");
		user=pro.getProperty("user");
		password=pro.getProperty("password");
	}
	
	private ConnectionFactory() {
	}
	
	public static ConnectionFactory getInstance() {
		return factory;
	}
	
	public Connection getConnection(){
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

package com.continuum.crmapp.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public enum DBConnection {
	INSTANCE;
	
	private Connection con = null;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private DBConnection() {
		String url = "";
		String dbName = "";
		String username = "";
		String password = "";
	
		try( FileInputStream input = new FileInputStream(getClass().getClassLoader().getResource("persistence-mysql.properties").getFile()) )
		{
			Properties props = new Properties();
			props.load(input);
			url = props.getProperty("db.url");
			dbName = props.getProperty("db.name");
			username = props.getProperty("db.username");
			password = props.getProperty("db.password");
			logger.info("db.url = " + url);
			logger.info("db.name = " + dbName);
			logger.info("db.username = " + username);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error while parsing data from properties file");
		}
		this.setConnection(url, dbName,username,password);
	}
	
	public Connection setConnection(String url, String dbName, String username, String password) {
		System.out.println("setting database connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection( url + "/" + dbName +"?serverTimezone=UTC&useSSL=false",
					username, password);
			Statement st = con.createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
			st.executeUpdate("USE " + dbName);
			st.executeUpdate("CREATE TABLE IF NOT EXISTS customer(cid INT PRIMARY KEY AUTO_INCREMENT, cfname VARCHAR(255), clname VARCHAR(255), email VARCHAR(255))");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Connection getConnection() {
		return con;
	}
	
}

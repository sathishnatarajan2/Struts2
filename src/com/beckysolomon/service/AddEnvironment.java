package com.beckysolomon.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.beckysolomon.model.Environment;

public class AddEnvironment {

	public String addEnv(Environment env) {
		
		Connection conn = null;
		
		try {
			String URL = "jdbc:mysql://localhost/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "jive", "jive");

			String sql = "INSERT INTO environments (os, os_version, notes) "; 
			sql += " VALUES (?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, env.getOs());
			ps.setString(2, env.getVersion());
			ps.setString(3, env.getNotes());

			ps.executeUpdate();
			
			} catch (Exception e) {
				e.printStackTrace();
				return "ERROR";
			} finally {
				
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
		
		return "Environment " + env.getOs() + " "
		+ env.getVersion() + " " +  env.getNotes() 
		+ " added";
	}
}

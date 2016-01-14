package com.beckysolomon.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import com.beckysolomon.model.Environment;
import com.beckysolomon.service.AddEnvironment;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MainAction extends ActionSupport implements ModelDriven<Environment> {

	private static final long serialVersionUID = 1L;
	
	private Environment env = new Environment();
	
	ArrayList<Environment> list = new ArrayList<Environment>();

	
	public void validate() {
		if (StringUtils.isEmpty(env.getOs())) {
			addFieldError("os", "OS cannot be blank");
		}
		if (StringUtils.isEmpty(env.getVersion())) {
			addFieldError("version", "OS Version cannot be blank");
		}
	}

	public String execute() {
		
		Connection conn = null;

		AddEnvironment service = new AddEnvironment();
		System.out.println(service.addEnv(env));
		
		try {
			String URL = "jdbc:mysql://localhost/testdb";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "jive", "jive");

			String sql = "select * from environments";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){
				
				Environment env = new Environment();
				
				env.setId(rs.getString(1));
				env.setOs(rs.getString(2));
				env.setVersion(rs.getString(3));
				env.setNotes(rs.getString(4));
				
				list.add(env);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		} finally {
				
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
		return SUCCESS;
	}

	@Override
	public Environment getModel() {
		return env;
	}
	
	public ArrayList<Environment> getList() {
		return list;
	}

	public void setList(ArrayList<Environment> list) {
		this.list = list;
	}
	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}


}

package com.contact.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public int insertData(Connection conn, String sql,String str){
		int name_id = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,str);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Failed");
		}
		
		try {
			String sql_helper = "SELECT LAST_INSERT_ID() As last_id";

			Statement stmt = conn.createStatement();		
			ResultSet rs = stmt.executeQuery(sql_helper);
			
			while(rs.next()){
				name_id = rs.getInt("last_id");
				System.out.println(name_id);
			}

			rs.close();
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return name_id;
	}
	
	public void insertData(Connection conn, String sql, Long lg, int last_id){
		

		
		try {			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,last_id);
			ps.setLong(2, lg);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert Failed有错");
		}
	}
}

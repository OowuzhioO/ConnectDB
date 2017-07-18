package com.contact.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Correct {

	public void correctData(Connection conn, String sql, String str, String str1){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, str);
			ps.setString(2, str1);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Modify Failed");
		}
	}
	
	
	public void correctData(Connection conn, String sql, Long lg, Long lg1){
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, lg);
			ps.setLong(2, lg1);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Modify Failed");
		}
	}
}

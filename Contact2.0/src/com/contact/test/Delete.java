package com.contact.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public void deleteData(Connection conn, String sql, String str){
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, str);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Failed");
		}
	}
	
	
	public void deleteData(Connection conn, String sql, Long lg){
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setLong(1, lg);
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete Failed");
		}
	}
}

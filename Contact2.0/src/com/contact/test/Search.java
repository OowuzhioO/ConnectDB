package com.contact.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search {
	public void searchData(Connection connect,String sql,PrintWriter out){
		
	    try {
	    	Statement stmt = connect.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){

			   long num  = rs.getLong("Number");
			   long cellphone = rs.getLong("CN");
			   String name = rs.getString("Name");

			   out.println(" Name: " + name + "<br>");
			   out.println(",Number: " + num + "<br>");
			   out.println(", cellphone: " + cellphone + "<br>");
			   out.println("");

	
			}
			stmt.close();
		    rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Search Failed");
		}
	}
}

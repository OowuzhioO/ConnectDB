package com.contact.test;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

//@WebServlet("/Contact_New")
public class Contact_Add_Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Contact_Add_Form() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
//		String name = null;

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/telephone_directory";
		final String USER = "root";
		final String PASS = "anquan518moshi";

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "你到底爱不爱我！！！";
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + 
				"<html>\n" + 
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" 
				+ "<h1 align=\"center\">" + title + "</h1>\n" +
				"<ul>\n" +
				"<li><b>站点名</b>:" +
				name + "\n" +
				"<li><b>网址</b>:" +
				request.getParameter("url") + "\n" +
				"</ul>\n");
		try {

			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Successful Connection");


//			String sql = "SELECT NAME AS 'Name', NUMBER AS 'Number', CELLPHONE_NUM AS 'CN' FROM Contact_Name JOIN Contact_NUM ON(Contact_Name.id = Contact_NUM.c_id) JOIN Contact_Cell ON(Contact_Name.id = Contact_Cell.cc_id) ORDER BY Name";
//
//			Search sch = new Search();
//			sch.searchData(conn, sql, out);
//
//			String sql2 = "insert into Contact_Name(NAME) values(?)";
//			String sql3 = "insert into Contact_Num (c_id,NUMBER) values(?,?)";
//			String sql4 = "insert into Contact_Cell (cc_id,CELLPHONE_NUM) values(?,?)";
//
//			Insert inst = new Insert();
//			int last_id = inst.insertData(conn, sql2, "Haowen");
//			inst.insertData(conn, sql3, 123456789l, last_id);
//			inst.insertData(conn, sql4, 987654321L, last_id);
//
//			 String sql5 = "delete from Contact_Name where NAME=?";
//			 String sql6 = "delete from Contact_Num where NUMBER=?";
//			 String sql7 = "delete from Contact_Cell where CELLPHONE_NUM=?";
//			
//			 Delete dlt = new Delete();
//			 dlt.deleteData(conn, sql5, "Haowen");
//			 dlt.deleteData(conn, sql6, 123456789l);
//			 dlt.deleteData(conn, sql7, 987654321l);
//
//			String sql8 = "update Contact_Name set NAME=? where NAME=?";
//			String sql9 = "update Contact_Num set NUMBER=? where NUMBER=?";
//			String sql10 = "update Contact_Cell set CELLPHONE_NUM=? where CELLPHONE_NUM=?";
//
//			Correct mdf = new Correct();
//			mdf.correctData(conn, sql8, "HaowenJiang", "Haowen");
//			mdf.correctData(conn, sql9, 111122222l, 123456789l);
//			mdf.correctData(conn, sql10, 999998888l, 987654321l);

			out.println("</body></html>");

			conn.close();
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
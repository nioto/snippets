package com.github.nioto.snippets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

/**
 * Hello world!
 *
 */

public class Main {
	
  
  
  static void closeQuietly(AutoCloseable c) {
  	if( c == null) return;
  	try {
  		c.close();
  	} catch(Exception e) {
  		// do nothing
  	}
  }
  
  
  static void createData(Connection c) 
  throws SQLException {
    Statement stmt = null;
    try {
	    stmt = c.createStatement();
	    String sql = "CREATE TABLE DATA " +
	                 "(ID INT PRIMARY KEY     NOT NULL," +
	                 " NAME           TEXT    NOT NULL," + 
	                 " INFO        CHAR(50))"; 
	    stmt.executeUpdate(sql);

	    sql = "INSERT INTO DATA (ID,NAME,INFO) " +
          "VALUES (1, 'John', 'Eclipse' );"; 
	    stmt.executeUpdate(sql);
	    sql = "INSERT INTO DATA (ID,NAME,INFO) " +
          "VALUES (2, 'Paul', 'IntelliJ' );"; 
	    stmt.executeUpdate(sql);
	    sql = "INSERT INTO DATA (ID,NAME,INFO) " +
          "VALUES (3, 'Kevin', 'Netbeans' );"; 
	    stmt.executeUpdate(sql);
    } finally {
    	closeQuietly(stmt);
    }
  }
  
	public static void main(String[] args) {

		
	  Connection c = null;
		SQLiteConfig config = new SQLiteConfig();
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite::memory:", config.toProperties());
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Statement st = null;
		ResultSet rs = null;
		try {
			createData(c);
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM DATA ORDER BY 2 ASC");
			while ( rs.next()) {
				System.out.println( rs.getInt(1) );
				System.out.println( rs.getString(2) );
				System.out.println( rs.getString(3));
				System.out.println("###############");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally{
			closeQuietly(rs);
			closeQuietly(st);
			closeQuietly(c);
		}
		
	}
}

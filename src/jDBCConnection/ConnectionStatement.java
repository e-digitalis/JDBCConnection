package jDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionStatement {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT name, population FROM city ORDER BY name ASC LIMIT 100 OFFSET 3400;";
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "lexicon");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				//System.out.println(rs.getString("name"));
				System.out.println(rs.getString("name") + ", " + rs.getInt("population"));
			}
			
			//city, first 100, alphabetical order, population

		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		finally {
//			conn.close();
//			stmt.close();
//			rs.close();
//		}

	}

}

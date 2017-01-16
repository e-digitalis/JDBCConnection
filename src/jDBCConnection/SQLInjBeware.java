package jDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjBeware {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {


			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "lexicon");
			stmt = conn.createStatement();
			String input = "\"Alabama\" or 1=1";
			String sql = "SELECT * FROM city ORDER BY name ASC LIMIT 1000"; // WHERE name = " + input; 
			rs = stmt.executeQuery(sql);
			while (rs.next()){
				//System.out.println(rs.getString("name"));
				System.out.println("Name of city: " + rs.getString("Name") + ", 	Population " + rs.getInt("population"));
			}

			//city, first 100, alphabetical order, population

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {try {


		} catch(Exception e) {

			// Error Handling

		} finally {

			try { if (rs != null) rs.close();

			} catch (Exception e) {};


			try { if (stmt != null) stmt.close();

			} catch (Exception e) {};


			try { if (conn != null) conn.close();

			} catch (Exception e) {};


		}

		}


	}
	
}

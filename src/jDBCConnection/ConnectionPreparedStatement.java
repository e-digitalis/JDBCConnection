package jDBCConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPreparedStatement {


	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT Name, population FROM city WHERE  Name = ? ORDER BY name ASC;";

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "lexicon");
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Stockholm");

			rs = stmt.executeQuery();
			while (rs.next()){
				//System.out.println(rs.getString("name"));
				System.out.println(rs.getString("name") + ", " + rs.getInt("population"));
			}

			//city, first 100, alphabetical order, population

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		//			finally {
		//				conn.close();
		//				stmt.close();
		//				rs.close();
		//			}

	}

}


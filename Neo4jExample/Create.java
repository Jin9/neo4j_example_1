package Neo4jExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("org.neo4j.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:neo4j://localhost:7474","neo4j","094991235");
		
		/*
		String sql = "MATCH (p {name: 'Jin Wongwises'}) RETURN p";
		try(PreparedStatement ps = conn.prepareStatement(sql)){
			// ps.setString(1, "Jin Wongwises");
			// ps.setInt(2, 1992);
			// int output = ps.executeUpdate();
			// System.out.println(output);
			
			ResultSet res = ps.executeQuery();
			System.out.println(res);
		};
		*/
		String sql = "MATCH p0 RETURN p0";
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		int count = 0;
		while(res.next()){
			ResultSetMetaData resm = res.getMetaData();
			System.out.print ( count++ );
			for(int i=1, cols = resm.getColumnCount(); i <= cols ; i++ ){
				String r = resm.getColumnLabel(i) + " : " + res.getObject(i);
				System.out.println(" : "+r );
			}
			
		}
		
		
	}

}

package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParoleDAO {
	
	public boolean isCorretto(String parola) {
		String sql= "SELECT nome " + 
				"FROM parola " + 
				"WHERE nome= ?";
		Connection conn;
		boolean bol=false;
		try {
			conn= ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs= st.executeQuery();
			while(rs.next()) {
				bol=true;
			}
			conn.close();
		}catch(SQLException e) {
			
			throw new RuntimeException(e);
		}
		return bol;
	}

}

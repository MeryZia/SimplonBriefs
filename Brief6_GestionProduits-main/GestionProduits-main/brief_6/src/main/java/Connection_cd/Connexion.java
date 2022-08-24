package Connection_cd;

import java.sql.*;


public class Connexion {
	
		
	    public Connection conn;
		
	    public Connection connect ()  {


	        String url = "jdbc:postgresql://localhost:5432/Brief6";
	        String username = "postgres";
	        String password = "1234";


	        try {
	        	
	            return DriverManager.getConnection(url, username, password);

	            //conn.close();

	        } catch (SQLException e) {
	            System.out.println("Error");
	            e.printStackTrace();
	        }
	        return null;
	    }
		
	}




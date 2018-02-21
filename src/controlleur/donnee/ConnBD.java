package controlleur.donnee;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnBD {
	
	private Connection com;
	
	public ConnBD() {
		this.setCom(null);
	}
	
	public Connection connect() {
		Connection com=null;
		try {
			
			//je charge tout d'abord le driver ou connecteur jdbc
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//cree le lien de connection
		 com=DriverManager.getConnection("jdbc:mysql://localhost:3306/indigopro", "root", "la7saintete");
				
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return com;
		//return null;
	}

	public Connection getCom() {
		return com;
	}

	public void setCom(Connection com) {
		this.com = com;
	}
	
	











	
	
}

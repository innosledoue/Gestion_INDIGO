package controlleur.donnee;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnexionBD {
	 
	public ConnexionBD() {
		
}

	public Connection connect() {
		Connection com=null;
		try {
			
			//je charge tout d'abord le driver ou connecteur jdbc
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//cree le lien de connection
		 com=DriverManager.getConnection("jdbc:mysql://localhost:3306/Person", "root", "la7saintete");
				
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return com;
		//return null;
	}
	
	/*public int verife(String ert,String ete) {
	
		try {
			//je charge tout d'abord le driver ou connecteur jdbc
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//cree le lien de connection
			com=DriverManager.getConnection("jdbc:mysql://localhost:3306/Person", "root", "la7saintete");
			//creer la syntaxe de requete
			String requete="SELECT*FROM profil;";
	
				query=com.createStatement();
				result=query.executeQuery(requete);
			while(result.next()) {
				if(result.getString("speudo").equals(ert)){
					if(result.getString("mot_passe").equals(ete)) {
						sens=1;
					}}
					if(result.getString("speudo").equals(ert)){
						if(!result.getString("mot_passe").equals(ete)) {
							sens=2;
						}					
					}
					if(!result.getString("speudo").equals(ert)){
						if(result.getString("mot_passe").equals(ete)) {
							sens=3;
						}}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			result.close();
			com.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.
		}
		
		return sens;
	}
	
	public void ferme() throws SQLException {
		query.close();
		com.close();
		}
	public boolean verifeMOT(String ert) {
		ten=false;
		try {
		//je charge tout d'abord le driver ou connecteur jdbc
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//cree le lien de connection
		com=DriverManager.getConnection("jdbc:mysql://localhost:3306/Person", "root", "la7saintete");
		//creer la syntaxe de requete
		String requete="SELECT*FROM profil;";

			query=com.createStatement();
			result=query.executeQuery(requete);
			
		
			while(result.next()) {
				if(result.getString("mot_passe").equals(ert)){
					ten=true;
				}
			}
			query.close();
			com.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ten;
	}*/
}

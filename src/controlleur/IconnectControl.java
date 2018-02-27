package controlleur;


///import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;


import controlleur.donnee.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
//import javafx.stage.StageStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;


public class IconnectControl implements Initializable {
	
	private ConnexionBD base;
	Personne person,person1;
	private  ArrayList<Personne> genre;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	private Stage refdeConnect,refMenu,refdeMenuC;
	
	
	//variable dont l'id est specifier dans le fichier fxml
	@FXML
	private Label msg,msg1,lb_r,lb_r1;
	@FXML
	private TextField user;
	@FXML
	private ImageView error,error1;
	@FXML
	private PasswordField pwd;
	@FXML 
	private RadioButton rdbt_etat;
	@FXML
	private Button bt_test;
	@FXML
	private CheckBox ch_r;

	
	
	//le constructeur pardefaut
	public IconnectControl() {
		
	}
	
	//cette methode est automatiquement execute au chargement de l'interface graphique Iconnect
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		genre=new ArrayList<Personne>();
		base=new ConnexionBD();
		Connection col=base.connect();
		rdbt_etat.setText("Connexion Locale etablit");
		rdbt_etat.setSelected(true);
		error.setVisible(false);
		error1.setVisible(false);
		
	
		
		try {
			ResultSet rs=col.createStatement().executeQuery("SELECT * FROM profil;");
			
			while(rs.next()) {
				genre.add(new Personne(rs.getInt("idProfil"),rs.getString("speudo"),rs.getString("mot_passe")));	
			}
		
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Probleme de  connexion a la base de donne");
			rdbt_etat.setText("Error veuiller consulter votre adminstrateur");
		}
		
		
		
		rdbt_etat.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
		    @Override
		    public void handle(KeyEvent event) {
		        event.consume();
		    }
		});
		rdbt_etat.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent event) {
		        event.consume();
		    }
		});
		/*bt_test.setOnMouseClicked(EventHandler<MouseEvent e>(){
	
		public void handle(MouseEvent e) {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				if(e.getClickCount()==2) {
					lb_test.setText("voila ca oh hihihihih !!!!!!");
				}
			}
		
		}
		
		}
		);*/
		
		
	}
		
	
	

	public void setConnect(Stage ter) {
		this.refdeConnect=ter;
	}
	public void setConnect1(Stage ter) {
		this.refdeMenuC=ter;
	}
	
	
	public void connect() throws IOException, SQLException{
		
		if(pwd.getText().isEmpty()) { msg1.setText("Incorrect! champs vide");}
		if(user.getText().isEmpty()) { msg.setText("Incorrect! champs vide");}
		
		if(!user.getText().isEmpty() &&  !pwd.getText().isEmpty())
		{   
						
			if(verifie()==1) 
				{
					refMenu = new Stage();
					refMenu.setTitle("SARL INDIGO");
					refMenu.getIcons().add(img);
					try {
						// Load root layout from fxml file.
						FXMLLoader loader = new FXMLLoader();
						loader.setLocation(IconnectControl.class.getResource("vue/MenuApp.fxml"));
						AnchorPane anchor= (AnchorPane) loader.load();
						
						// etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
                        MenuControl controller = loader.getController();
						controller.setMenu(refMenu);
						
						// Show the scene containing the root layout.
						Scene scene = new Scene(anchor);
						refMenu.setScene(scene);
						refMenu.show();
						try {
							refdeConnect.close();
						}catch(Exception e) {
							refdeMenuC.close();
						}
	                    		
	            
						} catch (IOException e) {
							e.printStackTrace();
								}

						//stage.initModality(Modality.WINDOW_MODAL);
						//stage.initOwner(((Node) event.getSource()).getScene().getWindow());
						
						}
			if(verifie()==3){
									msg1.setText("Mot de Passe Incorrect");
									error1.setVisible(true);
								}
			if(verifie()==2) {
									msg.setText("Speudo Incorrect");
									error.setVisible(true);
								}
			if(verifie()==0){
									msg.setText("Speudo Incorrect");
									error.setVisible(true);
									error1.setVisible(true);
									msg1.setText("Mot de Passe Incorrect");
								}
							}
						}
		
		
						
	
	//permet de verifier de la presence de utilisateur dans la base de donnee
	private int verifie() {
		ListIterator<Personne> li=genre.listIterator();
		int resul=0;
		while(li.hasNext()) {
			person=li.next();
		if(person.getspeudo().equals(user.getText()) &&  person.getMot_passe().equals(pwd.getText())) 
			{
			resul=1;
			}
		if(!person.getspeudo().equals(user.getText()) &&  person.getMot_passe().equals(pwd.getText())) 
		{
		resul=2;
		}
		if(person.getspeudo().equals(user.getText()) &&  !person.getMot_passe().equals(pwd.getText())) 
		{
		resul=3;
		}
			
	    }
		return resul;
		}
	
	
	
	
	//reinitialiser les champs
	public void annule() {
		user.clear();;
		pwd.clear();;
		error.setVisible(false);
		error1.setVisible(false);
		msg.setText("");
		msg1.setText("");
	}
	//lorsque le focus est sur le champs textfield 
		@FXML
		public void TextFieldfocus() {
			msg.setText("");
			error.setVisible(false);
		}
		
		@FXML
		public void PasswordFieldfocus() {
			msg1.setText("");
			error1.setVisible(false);
		}
		//Methode permettant l'action double click
		public void test( MouseEvent e) {
			if(e.getButton().equals(MouseButton.PRIMARY)) {
				if(e.getClickCount()==2) {
					
				}
			}
		}
		
		
		/*while(li.hasNext()) {
		//System.out.println(li.next().getspeudo()+"    "+li.next().getMot_passe());
	
	System.out.println(person.getspeudo().equals(user.getText())+"    "+person.getMot_passe().equals(pwd.getText()));
	//person.setSpeudo(user.getText());
	//person.setSpeudo(pwd.getText());
	//System.out.println(genre.contains(person));
	}*/
		//msg.setText(String.valueOf(ert) );
		// msg1.setText(String.valueOf(est) );
			//}

		/* TODO Auto-generated method stub
		System.out.println("hello le nongfr");
		genre=base.ListePerson();
		li=genre.listIterator();*/
		
		//person.setSpeudo(user.getText());
		//person.setSpeudo(pwd.getText());
		
		//choix=controller.getboolean();
		
		/*try {
			col.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("fermeture  de la base de donne  ERROR");
		}*/
}

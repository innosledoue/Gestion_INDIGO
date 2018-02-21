package controlleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.ResourceBundle;

import controlleur.donnee.Client;
import controlleur.donnee.ConnBD;
import controlleur.donnee.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class Modifi_ClientsControl implements Initializable {

	
	private Iclient_MenuControl main,main2,main1;
	private Stage stage,stage1,stage2,exit;
	private ConnBD donne;
	private ObservableList<Client> base1;
	private ArrayList<Client>base;
	private Connection com;
	private ResultSet result;
	
	@FXML
	private TableView<Client>table;
	@FXML
	private TableColumn<Client,String> tcode;
	@FXML
	private TableColumn<Client,String> tnom;
	@FXML
	private TableColumn<Client,String> tprenom;
	@FXML
	private TableColumn<Client,String> tville;
	@FXML
	private TableColumn<Client,String> tdate;
	@FXML
	private ComboBox<String> cb;
	@FXML
	private TextField tx_1,code,nom,prenom,adresse,codeP,tel,email,ville,mobile,date;
	@FXML
	private TextArea texte;
	@FXML
	private CheckBox carte;
	@FXML
	private Button bt_rech,bt_ok,bt_suppr;
	@FXML
	private Label lb_new,lb_code,lb_nom,lb_prenom,lb_ville,lb_addresse,lb_email,lb_mobile,lb_tel_fix,lb_remarque,lb_date,lb_codeP;
	
	String axe;
	
	
	public Modifi_ClientsControl() {
		
	}
	
	
	public void setControl1(Iclient_MenuControl ert) {
		this.main=ert;
		try{
        	exit=main.getStage();
        	 lb_new.setText("Recherche de client dans le registre clientèle ");
        	 
        	 lb_code.setVisible(true);
        	 lb_nom.setVisible(true);
        	 lb_prenom.setVisible(true);
        	 lb_ville.setVisible(true);
        	 lb_addresse.setVisible(true);
        	 lb_email.setVisible(true);
        	 lb_mobile.setVisible(true);
        	 lb_tel_fix.setVisible(true);
        	 lb_remarque.setVisible(true);
        	 lb_date.setVisible(true);
        	 lb_codeP.setVisible(true);
        	 
        	 code.setVisible(true);
        	 nom.setVisible(true);
        	 prenom.setVisible(true);
        	 adresse.setVisible(true);
        	 codeP.setVisible(true);
        	 tel.setVisible(true);
        	 email.setVisible(true);
        	 ville.setVisible(true);
        	 mobile.setVisible(true);
        	 date.setVisible(true);
        	}
		catch(NullPointerException e) {
		}
	}
	public void setControl2(Iclient_MenuControl ert) {
		this.main1=ert;
		try{
        	exit=main1.getStage();
        	 lb_new.setText("Modification de client dans le registre clientèle ");
        	}
		catch(NullPointerException e) {
		}
	}
	public void setControl3(Iclient_MenuControl ert) {
		this.main2=ert;
		try{
        	exit=main2.getStage();
        	 lb_new.setText("Suppresion  du client dans le registre clientèle ");
        	}
		catch(NullPointerException e) {
		}
	}
	
	/*public void setControl3(Iclient_MenuControl ert) {
		this.main2=ert;
		
	}*/


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//initialise au chargement de la fenetre ou interface  mes differents controls
		
		base= new ArrayList<Client>();
        base1=FXCollections.observableArrayList();
        
		donne=new ConnBD();
		com=donne.connect();
		try {//interrogation et recuperation des informations de la base de donnee
			
			ResultSet sx=com.createStatement().executeQuery("SELECT * FROM clients;");
			
			while(sx.next()) {
				base.add(new Client(sx.getString("code"),sx.getString("nom"),sx.getString("prenom"),sx.getString("ville"),sx.getString("code_postal"),sx.getString("addresse"),sx.getString("mobile"),sx.getString("email"),sx.getString("remarque"),sx.getString("tel_fixe"),sx.getInt("carte_fidele"),DateText(sx.getDate("date"))));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Probleme de  connexion a la base de donne");
		}
		
		//demarche servant a initialise une tableview avec les donne lue d'une base de donne
			// initialiser la table client avec ses differrentes column
		
		//tcarte.setCellValueFactory(cellData-> cellData.getValue().getPropertyCarte().asObject());
		//table_carte.setCellValueFactory(new PropertyValueFactory<Client,Integer>("carte_fidele"));
		
		tcode.setCellValueFactory(new PropertyValueFactory<Client,String>("code"));
		tnom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
		tprenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
		tville.setCellValueFactory(new PropertyValueFactory<Client,String>("ville"));
		tdate.setCellValueFactory(new PropertyValueFactory<Client,String>("date"));
		table.setRowFactory( tv -> {
			   TableRow<Client> row = new TableRow<>();
			   row.setOnMouseClicked(e -> {
			      if (e.getClickCount() == 2 && (!row.isEmpty()) ) {
			    	
			         try {
			        	edit(table.getSelectionModel().getSelectedItem());
					} catch (IOException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}                   
			      }
			   });
			   person=table.getSelectionModel().getSelectedItem();
			   return row;
			});
		
		table.setItems(null);
		//table.setItems(base);
		//table.setVisible(false);
	
		cb.getItems().add("CODE");
		cb.getItems().add("NOM");
		
		cb.valueProperty().addListener(observable->  axe=cb.getSelectionModel().getSelectedItem().toString());
		
		
	}
	
	
	//methode qui permet le typage d'une Date en String
	public String DateText(Date ert) {
		SimpleDateFormat temp=new SimpleDateFormat("dd-MM-YYYY");
		String textDate = temp.format(ert);
		return textDate;
	}
	
	@FXML
	public void recherche() {
		base1.clear();
		ListIterator<Client> li=base.listIterator();
		//int resul=0;
		Client person=new Client();
		while(li.hasNext()) {
			person=li.next();
		if(person.getCode().equals(tx_1.getText()) ||  person.getNom().equalsIgnoreCase(tx_1.getText())) 
			{
			base1.add(new Client(person.getCode(),person.getNom(),person.getPrenom(),person.getVille(),person.getCode_postal(),person.getAddresse(),person.getMobile(),person.getEmail(),person.getRemarque(),person.getTel(),person.getCarteF(),person.getDate()));
			}
			}
		if(!base1.isEmpty()) {
		table.setItems(base1);
		table.setVisible(true);}
		
		
}
	
	public void edit(Client eret) {
		
	}
	

}

package controlleur;

import controlleur.donnee.*;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;

public class Iclient_MenuControl  implements Initializable {  
	
	private ConnBD donne;
	private Connection com;
	private ObservableList<Client> base;
	
	private MenuControl main;
	private Personne person;
	Stage stage;
	
	@FXML
	private TableView<Client>table;
	@FXML
	private TableColumn<Client,String> table_code;
	@FXML
	private TableColumn<Client,String> table_nom;
	@FXML
	private TableColumn<Client,String> table_prenom;
	@FXML
	private TableColumn<Client,String> table_ville;
	@FXML
	private TableColumn<Client,Integer> table_carte;
	@FXML
	private TableColumn<Client,String> table_date;
	@FXML
	ComboBox<String> bt_combo;
	@FXML
	TextField txt;




	
	
	public Iclient_MenuControl() {
		
	}
	public Stage getStage() {
		return this.stage;
		}
	
	public void setControl(MenuControl ter) {
		this.main=ter;
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	      //TODO Auto-generated method stub
		
		base=FXCollections.observableArrayList();
		donne=new ConnBD();
		com=donne.connect();
		try {
			ResultSet sx=com.createStatement().executeQuery("SELECT * FROM clients ORDER BY date DESC;");
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
		table_code.setCellValueFactory(new PropertyValueFactory<Client,String>("code"));
		table_carte.setCellValueFactory(cellData-> cellData.getValue().getPropertyCarte().asObject());
		//table_carte.setCellValueFactory(new PropertyValueFactory<Client,Integer>("carte_fidele"));
		table_nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
		table_prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
		table_ville.setCellValueFactory(new PropertyValueFactory<Client,String>("ville"));
		table_date.setCellValueFactory(new PropertyValueFactory<Client,String>("date"));
		table.setItems(null);
		table.setItems(base);
		
		bt_combo.getItems().add("Par default");
		bt_combo.getItems().add("CODE");
		bt_combo.getItems().add("NOM");
		bt_combo.getItems().add("PRENOM");
		
		/*bt_combo.valueProperty().addListener(observable->  rio(bt_combo.getValue()));*/
		
		// reagir a tout changement fait sur la tableview
	    table.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> showPersonDetails(newValue ));
		
		
					
	}
	  
	private Object showPersonDetails(Client newValue) {
		// TODO Auto-generated method stub
		return null;
	}
	public void rio(String ert) {
		if(ert=="CODE") {
			table_code.setSortable(true);
			table_code.setSortType(SortType.ASCENDING);
			
		}
		if(ert=="NOM") {
			table_nom.setSortable(true);
			table_nom.setSortType(SortType.ASCENDING);
		}
		if(ert=="PRENOM") {
			table_prenom.setSortable(true);
			table_prenom.setSortType(SortType.ASCENDING);
		}
		if(ert.equals("Par default")) {
			table_date.setSortable(true);
			table_date.setSortType(SortType.ASCENDING);
		}
	}
	
	@FXML
	public void clientAjout() throws Exception {
	     Stage exit=main.getStage();
	     
		 stage = new Stage();
         stage.setTitle("SARL INDIGO");
          // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Iclient_MenuControl.class.getResource("vue/IclientAjout.fxml"));
            AnchorPane anchor= (AnchorPane) loader.load();
          
            Scene scene = new Scene(anchor);
            stage.setScene(scene);
            stage.show();
            exit.close();
	}
	
          
        @FXML
	public void clientRech() throws Exception {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
     stage.show(); 
     exit.close();

        
	}
	@FXML
	public void clientSupp() throws IOException {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
      
        stage.show();
        exit.close();
	}
	@FXML
	public void clientModif() throws IOException {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
       
        stage.show();
        exit.close();
       
	}
	@FXML
	public void clientApercuImpr() throws IOException {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        //stage.initModality(Modality.WINDOW_MODAL);
        //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
     stage.show();   
     exit.close();
     
	}
	
	
	//methode qui permet le typage d'une Date en String
	public String DateText(Date ert) {
		SimpleDateFormat temp=new SimpleDateFormat("dd-MM-YYYY");
		String textDate = temp.format(ert);
		return textDate;
	}
	
	public TableView<Client> getTable() {
		return table;
	}
	
	
	//fait Parste de Integer en int
	public int forme(Integer rt) {
		return rt.intValue();
	}
	
	public Personne getPerson() {
		return person;
	}
	public void setPerson(Personne person) {
		this.person = person;
	}
		
	//ici on utlise la fonction lammda de java 8 mais le soucis est que la Integer generais des errur a voir
			//table_nom.setCellValueFactory(cellData -> cellData.getValue().getPropertyNom());
			//table_prenom.setCellValueFactory(cellData -> cellData.getValue().getPropertyPrenom());
			//table_carte.setCellValueFactory(cellData -> cellData.getValue().getCarte());
			//table_ville.setCellValueFactory(cellData -> cellData.getValue().getPropertyVille());
			//table_date.setCellValueFactory(cellData -> cellData.getValue().getPropertyDate());

	// loader.setLocation(IconnectControl.class.getResource("vue/IclientPresent.fxml"));
    // AnchorPane sub=(AnchorPane) loader.load();
     // AnchorPane.setTopAnchor(sub,0.0);
      //AnchorPane.setTopAnchor(button, 10.0); 
     // AnchorPane.setLeftAnchor(button, 10.0); 
     // AnchorPane.setRightAnchor(button, 65.0);
      // Show the scene containing the root layout.
	
	//System.out.println(base.get(0).getCode()+"  "+base.get(0).getNom()+"  "+base.get(0).getCarteF());
	//System.out.println(base.get(1).getCode()+"  "+base.get(1).getNom()+"  "+base.get(1).getCarteF());
	
	 // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
    //MenuControl controller = loader.getController();
    //controller.setControl(this);
    //choix=controller.getboolean();
    //stage.initModality(Modality.WINDOW_MODAL);
//stage.initOwner(((Node) event.getSource()).getScene().getWindow());
//stage.show();
	
}

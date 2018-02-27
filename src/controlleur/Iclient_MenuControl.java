package controlleur;

import controlleur.donnee.*;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;

public class Iclient_MenuControl  implements Initializable {  
	
	private ConnBD donne;
	private Connection com;
	private ObservableList<Client> base;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	ArrayList<String>codelist=new ArrayList<String>();
	private Stage refdeClient,refMenu,refRech,refMod,refInfo,refAjout,refSupp;

	private Client person;
	
	
	
	
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
	private ComboBox<String> bt_combo;
	@FXML
	private TextField txt;
	@FXML
	private Button bt_NC;



	
	
	public Iclient_MenuControl() {
		
	}
	/*public Stage getStage() {
		return this.stage;
		}
	public Stage getStage1() {
		return this.stage1;
		}
	public Stage getStage2() {
		return this.stage2;
		}
	public Stage getStage3() {
		return this.stage3;
		}
	public Stage getStage4() {
		return this.stage4;
		}
	public Stage getStage5() {
		return this.stage5;
		}
	public Stage getStage6() {
		return this.stage6;
		}

	public Stage getstage7() {
		return stage7;
	}*/
	
	
	public void setClient(Stage ter) {
		this.refdeClient=ter;
		
	}
	public Client getClient() {
		return  this.person;
	}
	
	
	
	public void setTable(Client eer) {
		this.table.getItems().add(eer);
	}
	public TableView<Client> getTable() {
		return this.table;
	}
	
	
	
	
	/*public void setClient(Client perso) {
		person = perso;
	}*/
	
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
			    codelist.add(sx.getString("code"));
			}
			try{
				sx.close();
				com.close();
			}catch(Exception edr) {
				
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
		
	
		
		
	
		table.setRowFactory( tv -> {
			   TableRow<Client> row = new TableRow<>();
			   row.setOnMouseClicked(e -> {
			      if (e.getClickCount() == 2 && (!row.isEmpty()) ) {
			    	
			         try {
			        	voirInfo(table.getSelectionModel().getSelectedItem());
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
		
			bt_NC.setOnMouseClicked(e-> {
					if(e.getClickCount()>=2) {
						e.consume();
				}
			});
	}
	/* methode tres tres importante permet le double click
	  @FXML
	public void action (MouseEvent e) {
		  if(e.getButton().equals(MouseButton.PRIMARY)) {
				if(e.getClickCount()==2) {
					 table.getSelectionModel().selectedItemProperty().addListener(
					            (observable, oldValue, newValue) -> {
									try {
										voirInfo(newValue);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								});
				}
			}
		// TODO Auto-generated method stub
		
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
	}*/
	

	public void voirInfo( Client homme) throws IOException, SQLException, Exception {
		if(homme!=null) {
			 try {  
				 
				 // Create the dialog Stage.
			        refInfo = new Stage();
			        refInfo.setTitle("SARL INDIGO");
			        refInfo.getIcons().add(img);
			        
			        // Load the fxml file and create a new stage for the popup dialog.
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IclientAjout.fxml"));
			        AnchorPane page = (AnchorPane) loader.load();
			        	
			        IclientAjoutControl controller = loader.getController();
			        controller.setInfo(refInfo);
			        controller.setClient(homme);
			        
			      
			        refInfo.initModality(Modality.WINDOW_MODAL);
			        refInfo.initOwner(refdeClient);
			        Scene scene = new Scene(page);
			        refInfo.setScene(scene);

			        // Set the person into the controller.
			        

			        // Show the dialog and wait until the user closes it
			        refInfo.showAndWait();

			       
			    } catch (IOException e) {
			        e.printStackTrace();
			      
			    }
			
		}
			
		
	}
	
	@FXML
	public void clientAjout() throws Exception {
		try {
			    refAjout= new Stage();
		        refAjout.setTitle("SARL INDIGO");
		        refAjout.getIcons().add(img);
		        // Load the fxml file and create a new stage for the popup dialog.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IclientAjout.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        	
		        
		        // Create the dialog Stage.
		       
		        refAjout.initModality(Modality.WINDOW_MODAL);
		        refAjout.initOwner(refdeClient);
		        Scene scene = new Scene(page);
		        refAjout.setScene(scene);

		        // Set the person into the controller.
		        IclientAjoutControl controller = loader.getController();
		        controller.setcontrol1(this);
		        controller.setAjout(refAjout);
		        controller.setCodeList(codelist);
		

		        // Show the dialog and wait until the user closes it
		        refAjout.showAndWait();

		       
		    } catch (IOException e) {
		        e.printStackTrace();
		      
		    }

	}
	
          
     @FXML
	public void clientRech() throws Exception {
		refRech = new Stage();
        refRech.setTitle("SARL INDIGO");
        refRech.getIcons().add(img);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Modifi_Clients.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        refRech.setScene(scene);
        
        refRech.initModality(Modality.WINDOW_MODAL);
        refRech.initOwner(refdeClient);
        //permet de connecter les controleurs
        Modifi_ClientsControl controller = loader.getController();
         controller.setControl1(this);
         controller.setRech(refRech);
         
       refRech.showAndWait();
         
	}
     
    @FXML
 	public void clientModif() throws IOException {
 		
 		
 		refMod = new Stage();
         refMod.setTitle("SARL INDIGO");
         refMod.getIcons().add(img);
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(Iclient_MenuControl.class.getResource("vue/Modifi_Clients.fxml"));
         AnchorPane page = (AnchorPane) loader.load();
         Scene scene = new Scene(page);
         refMod.setScene(scene);
         Modifi_ClientsControl control=loader.getController();
         control.setControl2(this);
         control.setMod(refMod);
         
         //control.setTable(this.table);
         refMod.initModality(Modality.WINDOW_MODAL);
         refMod.initOwner(refdeClient);
         
         //controller.setClient(person);
         //stage.initModality(Modality.WINDOW_MODAL);
         //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
         refMod.showAndWait();
        
 	}

        
	@FXML
	public void clientSupp() throws IOException {
		refSupp = new Stage();
        refSupp.setTitle("SARL INDIGO");
        refSupp.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Modifi_Clients.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);
        Modifi_ClientsControl control=loader.getController();
        control.setControl3(this);
        control.setSupp(refSupp);
       
        refSupp.setScene(scene);
        refSupp.initModality(Modality.WINDOW_MODAL);
        refSupp.initOwner(refdeClient);
      
        refSupp.showAndWait();
	}
	/*	@FXML
	public void clientApercuImpr() throws IOException {

			refAper = new Stage();
	        refAper.setTitle("SARL INDIGO");
	        refAper.getIcons().setAll(new Image("Image_Pro/login/Startup-GP.png"));
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Modifi_Clients.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Scene scene = new Scene(page);
	        Modifi_ClientsControl control=loader.getController();
	        control.setControl3(this);
	       
	        stage5.setScene(scene);
	        stage5.initModality(Modality.WINDOW_MODAL);
	        stage5.initOwner(exit);
	      
	        stage5.showAndWait();
          
	}
		@FXML
		public void clientImpr() throws IOException {
				Stage exit=main.getStage();

				stage6 = new Stage();
		        stage6.setTitle("SARL INDIGO");
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Modifi_Clients.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        Scene scene = new Scene(page);
		        Modifi_ClientsControl control=loader.getController();
		        control.setControl3(this);
		       
		        stage6.setScene(scene);
		        stage6.initModality(Modality.WINDOW_MODAL);
		        stage6.initOwner(exit);
		      
		        stage5.showAndWait();
	          
		}
		
		*/
		
	@FXML
	public void Menu() throws IOException {
		//Stage exit=main.getStage();
		refMenu= new Stage();
        refMenu.setTitle("SARL INDIGO");
        refMenu.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setMenu1(refMenu);
        		
        Scene scene = new Scene(page);
        refMenu.setScene(scene);
        refMenu.show();
        refdeClient.close();
     
	}
	
	//methode qui permet le typage d'une Date en String
	public String DateText(Date ert) {
		SimpleDateFormat temp=new SimpleDateFormat("dd-MM-YYYY");
		String textDate = temp.format(ert);
		return textDate;
	}
	
	
	
	
	//fait Passe de Integer en int
	public int forme(Integer rt) {
		return rt.intValue();
	}
	
	
	
		
	//ici on utlise la fonction lammda de java 8 mais le soucis est que la Integer generais des erreur a voir
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
	
	/*table.setOnMouseClicked(new EventHandler<MouseEvent>() {
	   @Override 
	   public void handle(MouseEvent e) {
	      if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
	         txt.setText(table.getSelectionModel().getSelectedItem().getCode());                   
	      }
	   }
	});
bt_combo.valueProperty().addListener(observable->  rio(bt_combo.getValue()));*/

// reagir a tout changement fait sur la tableview
	
	//controller.setClient(person);
    //stage.initModality(Modality.WINDOW_MODAL);
    //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
	

	/*bt_combo.getItems().add("Par default");
	bt_combo.getItems().add("CODE");
	bt_combo.getItems().add("NOM");
	bt_combo.getItems().add("PRENOM");
	
	 * dans cette figure notre controlleu possede une liste deroulante dc l'action de click se fait sur les ligne soit les tablerow
	
	bt_combo.setOnMouseClicked(e-> {
		if(bt_combo.getSelectionModel().selectedItemProperty().equals("CODE")) {
			table_code.setSortable(true);
			table_code.setEditable(true);
		
		}
		if(bt_combo.getSelectionModel().selectedItemProperty().equals("NOM")) {
			table_nom.setSortable(true);
			table_nom.setEditable(true);
		}
		if(bt_combo.getSelectionModel().selectedItemProperty().equals("PRENOM")) {
			table_prenom.setSortable(true);
			table_prenom.setEditable(true);
		}
		if(bt_combo.getSelectionModel().selectedItemProperty().equals("Par default")) {
			table_date.setSortable(true);
			table_date.setEditable(true);
		} 
			
	
		
});*/
	
}

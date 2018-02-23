package controlleur;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import controlleur.donnee.Articles;
import controlleur.donnee.Client;
import controlleur.donnee.ConnBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ArticleMenu implements Initializable{

	
	private MenuControl main;
	private Stage stage,stage1,stage2,stage3,stage4,stage5,stage6,stage7;
	private ObservableList<Articles>base;

	
	private ConnBD donne;
	private Connection com;
	
	@FXML
	private TableView<Articles>table;
	@FXML
	private TableColumn<Articles,String> tcode;
	@FXML
	private TableColumn<Articles,String> tcodeCat;
	@FXML
	private TableColumn<Articles,String> tdesig;
	@FXML
	private TableColumn<Articles,Integer> tquan;
	@FXML
	private TableColumn<Articles,Double> tprix;
	
	@FXML
	private Button bt_new;
	private Articles person;
	
	

// Constructeur	
	public ArticleMenu() {
		
	}
	

	public Stage getStage() {
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
	}
	
	
	public void setControl(MenuControl ter) {
		this.main=ter;
		
	}
	public Articles getArticles() {
		return  this.person;
	}
	
	
	
	public void setTable(Articles eer) {
		this.table.getItems().add(eer);
	}
	public TableView<Articles> getTable() {
		return this.table;
	}
	
	
	
	
	/*public void setClient(Client perso) {
		person = perso;
	}*/
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	      //TODO Auto-generated method stub
		
		base = FXCollections.observableArrayList();
		 donne = new ConnBD();
		com=donne.connect();
		try {
			ResultSet sx=com.createStatement().executeQuery("SELECT * FROM articles ORDER BY date DESC;");
			while(sx.next()) {
				base.add(new Articles(sx.getString("code"),sx.getString("code_categorie"),sx.getString("designation"),sx.getInt("quantite"),sx.getDouble("prix_unitaire"),DateText(sx.getDate("date"))));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Probleme de  connexion a la base de donne");
		}
		
		//demarche servant a initialise une tableview avec les donne lue d'une base de donne
			// initialiser la table client avec ses differrentes column
		tcode.setCellValueFactory(new PropertyValueFactory<Articles,String>("code"));
		tcodeCat.setCellValueFactory(new PropertyValueFactory<Articles,String>("code_categorie"));
		tquan.setCellValueFactory(new PropertyValueFactory<Articles,Integer>("quantite"));
		tdesig.setCellValueFactory(new PropertyValueFactory<Articles,String>("designation"));
		tprix.setCellValueFactory(new PropertyValueFactory<Articles,Double>("prix_unitaire"));
	
		table.setItems(null);
		table.setItems(base);
		
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
		table.setRowFactory( tv -> {
			   TableRow<Articles> row = new TableRow<>();
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
		
			bt_new.setOnMouseClicked(e-> {
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
			tcode.setSortable(true);
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
	*/

	public void voirInfo( Articles produit) throws IOException, SQLException, Exception {
		if(produit!=null) {
			 try {
				  Stage exit=main.getStage();  
				 
				 // Create the dialog Stage.
			        stage = new Stage();
			        stage.setTitle("Edit Articles");
			        
			        // Load the fxml file and create a new stage for the popup dialog.
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticleAjout.fxml"));
			        AnchorPane page = (AnchorPane) loader.load();
			        	
			        IarticleAjoutControl controller = loader.getController();
			        controller.setcontrol1(this);
			        controller.setClient(homme);
			        
			      
			        stage.initModality(Modality.WINDOW_MODAL);
			        stage.initOwner(exit);
			        Scene scene = new Scene(page);
			        stage.setScene(scene);

			        // Set the person into the controller.
			        

			        // Show the dialog and wait until the user closes it
			        stage.showAndWait();

			       
			    } catch (IOException e) {
			        e.printStackTrace();
			      
			    }
			
		}
			
		
	}
	
	@FXML
	public void articleAjout() throws Exception {
		try {
			 Stage exit=main.getStage();
		        // Load the fxml file and create a new stage for the popup dialog.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticleAjout.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        	
		        
		        // Create the dialog Stage.
		        stage1  = new Stage();
		        stage1.setTitle("Edit Articles");
		        stage1.initModality(Modality.WINDOW_MODAL);
		        stage1.initOwner(exit);
		        Scene scene = new Scene(page);
		        stage1.setScene(scene);

		        // Set the person into the controller.
		        IarticleAjoutControl controller = loader.getController();
		        controller.setcontrol1(this);
		        controller.setClient(person);

		        // Show the dialog and wait until the user closes it
		        stage1.showAndWait();

		       
		    } catch (IOException e) {
		        e.printStackTrace();
		      
		    }

	}
	
          
     @FXML
	public void articleRech() throws Exception {
		Stage exit=main.getStage();
		stage2 = new Stage();
        stage2.setTitle("SARL INDIGO");
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/articleModifi.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        stage2.setScene(scene);
        
        stage2.initModality(Modality.WINDOW_MODAL);
        stage2.initOwner(exit);
        //permet de connecter les controleurs
        articleModifiControl controller = loader.getController();
         controller.setControl1(this);
         
       stage2.showAndWait();
         
	}
     
    @FXML
 	public void clientModif() throws IOException {
 		
 		Stage exit=main.getStage();
 		stage3 = new Stage();
         stage3.setTitle("SARL INDIGO");
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticlesModifi.fxml"));
         AnchorPane page = (AnchorPane) loader.load();
         Scene scene = new Scene(page);
         stage3.setScene(scene);
         Modifi_ClientsControl control=loader.getController();
         control.setControl2(this);
         
         //control.setTable(this.table);
         stage3.initModality(Modality.WINDOW_MODAL);
         stage3.initOwner(exit);
         
         //controller.setClient(person);
         //stage.initModality(Modality.WINDOW_MODAL);
         //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
         stage3.showAndWait();
        
 	}

        
	@FXML
	public void clientSupp() throws IOException {
		Stage exit=main.getStage();

		stage4 = new Stage();
        stage4.setTitle("SARL INDIGO");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticlesModifi.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);
        Modifi_ClientsControl control=loader.getController();
        control.setControl3(this);
       
        stage4.setScene(scene);
        stage4.initModality(Modality.WINDOW_MODAL);
        stage4.initOwner(exit);
      
        stage4.showAndWait();
	}
		@FXML
	public void Apercu_article() throws IOException {
			Stage exit=main.getStage();

			stage5 = new Stage();
	        stage5.setTitle("SARL INDIGO");
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticleImpr.fxml"));
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
		public void articleImpr() throws IOException {
				Stage exit=main.getStage();

				stage6 = new Stage();
		        stage6.setTitle("SARL INDIGO");
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticleImpr.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        Scene scene = new Scene(page);
		        Modifi_ClientsControl control=loader.getController();
		        control.setControl3(this);
		       
		        stage6.setScene(scene);
		        stage6.initModality(Modality.WINDOW_MODAL);
		        stage6.initOwner(exit);
		      
		        stage5.showAndWait();
	          
		}
		
		
		
	@FXML
	public void Menu() throws IOException {
		Stage exit=main.getStage();
		stage7= new Stage();
        stage7.setTitle("SARL INDIGO");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Iclient_MenuControl.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setControl1(this);
        		
        Scene scene = new Scene(page);
        stage7.setScene(scene);
        stage7.show();
        exit.close();
     
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
	

	

	
	
	
	
	
}

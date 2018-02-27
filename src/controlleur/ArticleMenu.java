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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ArticleMenu implements Initializable{

	

	private Stage  refdeArticle,refInfo,refAjout,refRech,refMod,refSupp,refMenu;
	private ObservableList<Articles> base;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	private ConnBD donne1;
	private Connection com1;

	
	@FXML
	private TableView<Articles> table;
	@FXML
	private TableColumn<Articles,String> tcode;
	@FXML
	private TableColumn<Articles,String> tcodeCat;
	@FXML
	private TableColumn<Articles,String> tdesig;
	@FXML
	private TableColumn<Articles,Integer> tquan;
	@FXML
	private TableColumn<Articles,Double> tprixU;
	
	@FXML
	private Button bt_new;
	
	
	private Articles produit;
	
	

// Constructeur	
	public ArticleMenu() {
		
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
		return this.stage7;
	}
	
	
	public void setControl1(MenuControl ter) {
		this.main=ter;
	}
	public void setTable(Articles eer) {
		this.table.getItems().add(eer);
	}
	
	*
	*/
	
	public void setArticle(Stage ter) {
		this.refdeArticle=ter;
		
		
	}
	public Articles getArticles() {
		return  this.produit;
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
		
		base=FXCollections.observableArrayList();
		 donne1 = new ConnBD();
		com1=donne1.connect();
		try {
			ResultSet sx=com1.createStatement().executeQuery("SELECT * FROM articles ORDER BY date DESC;");
			
			while(sx.next()) {
			base.add(new Articles(sx.getString("code"),sx.getString("code_categorie"),sx.getString("designation"),sx.getInt("quantite"),sx.getDouble("prix_unitaire"),DateText(sx.getDate("date"))));

			}
			try {
				sx.close();
				com1.close();
			}catch(Exception ed) {
				
			}
		} catch (Exception e) {
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
		tprixU.setCellValueFactory(new PropertyValueFactory<Articles,Double>("prix_unitaire"));
		table.setItems(base);
		
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
			   produit=table.getSelectionModel().getSelectedItem();
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

	public void voirInfo( Articles prod) throws IOException, SQLException, Exception {
		if(produit!=null) {
			 try {
				  
				 
				 // Create the dialog Stage.
			        refInfo= new Stage();
			        refInfo.setTitle("Edit Articles");
			        refInfo.getIcons().add(img);
			        
			        // Load the fxml file and create a new stage for the popup dialog.
			        FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(Iclient_MenuControl.class.getResource("vue/IarticleAjout.fxml"));
			        AnchorPane page = (AnchorPane) loader.load();
			        	
			        IarticleAjoutControl controller = loader.getController();
			        controller.setcontrol1(this);
			        controller.setInfo(refInfo);
			        controller.setClient(produit);
			        
			      
			        refInfo.initModality(Modality.WINDOW_MODAL);
			        refInfo.initOwner(refdeArticle);
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
	public void articleAjout() throws Exception {
		try {
			 
		        // Load the fxml file and create a new stage for the popup dialog.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(ArticleMenu.class.getResource("vue/IarticleAjout.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        	
		        
		        // Create the dialog Stage.
		        refAjout = new Stage();
		        refAjout.getIcons().add(img);
		        refAjout.setTitle("SARL Indigo");
		        refAjout.initModality(Modality.WINDOW_MODAL);
		        refAjout.initOwner(refdeArticle);
		        Scene scene = new Scene(page);
		        refAjout.setScene(scene);

		        // Set the person into the controller.
		        IarticleAjoutControl controller = loader.getController();
		        controller.setcontrol1(this);
		        controller.setAjout(refAjout);
		        //controller.setClient(person);

		        // Show the dialog and wait until the user closes it
		        refAjout.showAndWait();

		       
		    } catch (IOException e) {
		        e.printStackTrace();
		      
		    }

	}
	
          
     @FXML
	public void articleRech() throws Exception {
	
		refRech = new Stage();
        refRech.setTitle("SARL INDIGO");
        refRech.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ArticleMenu.class.getResource("vue/IarticleModifi.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Scene scene = new Scene(page);
        refRech.setScene(scene);
        
        refRech.initModality(Modality.WINDOW_MODAL);
        refRech.initOwner(refdeArticle);
        //permet de connecter les controleurs
        IarticleModifiControl controller = loader.getController();
         controller.setControl1(this);
         controller.setRech(refRech);
         
       refRech.showAndWait();
         
	}
     
    @FXML
 	public void articleModif() throws IOException {
 		refMod = new Stage();
         refMod.setTitle("SARL INDIGO");
         refMod.getIcons().add(img);
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(ArticleMenu.class.getResource("vue/IarticleModifi.fxml"));
         AnchorPane page = (AnchorPane) loader.load();
         Scene scene = new Scene(page);
         refMod.setScene(scene);
         IarticleModifiControl control=loader.getController();
         control.setControl2(this);
         control.setMod(refMod);
         
         //control.setTable(this.table);
         refMod.initModality(Modality.WINDOW_MODAL);
         refMod.initOwner(refdeArticle);
         
         //controller.setClient(person);
         //stage.initModality(Modality.WINDOW_MODAL);
         //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
         refMod.showAndWait();
        
 	}

        
	@FXML
	public void articleSupp() throws IOException {


		refSupp = new Stage();
        refSupp.setTitle("SARL INDIGO");
        refSupp.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ArticleMenu.class.getResource("vue/IarticleModifi.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        Scene scene = new Scene(page);
        IarticleModifiControl control=loader.getController();
        control.setControl3(this);
        control.setSupp(refSupp);
       
        refSupp.setScene(scene);
        refSupp.initModality(Modality.WINDOW_MODAL);
       refSupp.initOwner(refdeArticle);
      
        refSupp.showAndWait();
	}
	/*	@FXML
	public void Apercu_article() throws IOException {
			Stage exit=main.getStage();

			stage5 = new Stage();
	        stage5.setTitle("SARL INDIGO");
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(ArticleMenu.class.getResource("vue/IarticleImpr.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Scene scene = new Scene(page);
	        Modifi_ClientsControl control=loader.getController();
	        //control.setControl3(this);
	       
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
		        loader.setLocation(ArticleMenu.class.getResource("vue/IarticleImpr.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();
		        Scene scene = new Scene(page);
		        Modifi_ClientsControl control=loader.getController();
		        //control.setControl3(this);
		        stage6.setScene(scene);
		        stage6.initModality(Modality.WINDOW_MODAL);
		        stage6.initOwner(exit);
		        stage5.showAndWait();     
		}
		*/
	@FXML
	public void Menu() throws IOException {
	
		refMenu= new Stage();
        refMenu.setTitle("SARL INDIGO");
        refMenu.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ArticleMenu.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setMenu2(refMenu);
        Scene scene = new Scene(page);
        refMenu.setScene(scene);
        refMenu.show();
        refdeArticle.close(); 
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

package controlleur;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.ResourceBundle;
import controlleur.donnee.Articles;
import controlleur.donnee.ConnBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IarticleModifiControl {
	
	private ArticleMenu main,main1,main2,main4;
	private Stage stage,stage1;
	private Stage refdeMod,refdeSupp,refdeRech;
	private ConnBD donne;
	private ObservableList<Articles> base1;
	private ArrayList<Articles>base;
	private Image Img=new Image(getClass().getResourceAsStream("image.png"));
	private Connection com;
    private TableView<Articles>OWN,own1;
	private String critere;
	
	
	@FXML
	private TableView<Articles>table;
	@FXML
	private TableColumn<Articles,String> tcode;
	@FXML
	private TableColumn<Articles,String> tcodeC;
	@FXML
	private TableColumn<Articles,String> tdesig;
	@FXML
	private TableColumn<Articles,Integer> tquan;
	@FXML
	private TableColumn<Articles,Double> tprix;
	@FXML
	private ComboBox<String> cb;
	@FXML
	private ImageView imgs,img,img1;
	@FXML
	private TextField tx_1,tx_code,tx_cc,tx_prix,tx_qu,tx_date;
	@FXML
	private TextArea texte;

	
	@FXML
	private Button bt_rech,bt_ok,bt_suppr,bt_ajout;
	@FXML
	private Rectangle rectangle;
	@FXML
	private Label lb_new,lb_code,lb_cc,lb_desig,lb_qu,lb_prix,lb_date,lb_rien;
	
	private String axe;
	private int nbre,cartevaleur,a=0,m=0,p=0,er,imp=0;
	private Articles person=new Articles();
	private Articles personadd=new Articles();
	private String su,pwd,su1,pwd1;
	
	
	
	
	public IarticleModifiControl() {
		
	}
	
	
	public Stage getStage() {
		return this.stage;
		}

	public Stage getStage1() {
		return stage1;
	}
	
	
	public void  setRech(Stage A) {
		this.refdeRech=A;
	}
	public void  setMod(Stage A) {
		this.refdeMod=A;
	}
	public void  setSupp(Stage A) {
		this.refdeSupp=A;
	}
	
	
	
	public void setvaleur(String er,String ed) {
		this.su=er;
		this.pwd=ed;
	}
	public void setvaleur1(String er,String ed) {
		this.su1=er;
		this.pwd1=ed;
	}
	
	public void setControl1(ArticleMenu ert) {
		
		try{	
				this.main=ert;
					a=1;
	         	 lb_new.setText("Rechercher un Produit");
	         	 img.setVisible(true);
	         	}
	 		catch(Exception eee) {
	 			System.err.println(" ERROR VERIFY YOUR FILE"); 	 	 		}
			
		
	}
	
	public void setControl2(ArticleMenu ert) {
		
		 try{
			 this.main1=ert;
			 m=1;
			 OWN=main1.getTable();

	         	 lb_new.setText("Modification du Produit ");
	         	 
	         	 img1.setVisible(true);
	         	tx_cc.setEditable(true);
	         	tx_prix.setEditable(true);
	         	tx_qu.setEditable(true);
	         	texte.setEditable(true);
	         	 tx_date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	         	 /*tx_date.setEditable();
	         	lb_date1.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
	     		    @Override
	     		    public void handle(KeyEvent event) {
	     		        event.consume();
	     		    }
	     		});
	     		date.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
	     		    @Override
	     		    public void handle(MouseEvent event) {
	     		        event.consume();
	     		    }
	     		});*/
	         	
	         	// bt_ajout.setVisible(true);
	         	}
	 		catch(Exception e) {System.err.println("ERROR ICI  modification");
	}}
	public void setControl3(ArticleMenu ert) {
		this.main2=ert;
		 try{
	         	
	         	 lb_new.setText("Suppresion  du client dans le registre clientèle");
	         	 own1=main2.getTable();
	         	imgs.setVisible(true);
	         		p=1;
	         	 //bt_suppr.setVisible(true);
	         	}
	 		catch(Exception er) { System.err.println("ERROR ICI  suppresion");
	}
	}
	
	/*
	 * public void setControl4(ArticleMenu ert) {
	 
		this.main3=ert;
		 try{
	         	exit2=main3.getStage5();
	         	 lb_new.setText("Aperçu Donnée Client avant Impression");
	         	 own1=main3.getTable();
	         	 /*carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
	         		    @Override
	         		    public void handle(KeyEvent event) {
	         		        event.consume();
	         		    }
	         		});
	         		carte.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
	         		    @Override
	         		    public void handle(MouseEvent event) {
	         		        event.consume();
	         		    }
	         		})
	         		imp=1;
	         	 //bt_suppr.setVisible(true);
	         	}
	 		catch(Exception er) { System.err.println("ERROR ICI  suppresion");
	
	
	};*/
	
	
	/*public void setControl5(ArticleMenu ert) {
		this.main4=ert;
		 try{
	         	exit2=main4.getStage6();
	         	 lb_new.setText("Impression du Client");
	         	 own1=main4.getTable();
	         	 /*carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
	         		    @Override
	         		    public void handle(KeyEvent event) {
	         		        event.consume();
	         		    }
	         		});
	         		carte.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
	         		    @Override
	         		    public void handle(MouseEvent event) {
	         		        event.consume();
	         		    }
	         		});
	         	imp=2;
	         	 //bt_suppr.setVisible(true);
	         	}
	 		catch(Exception er) { System.err.println("ERROR ICI  suppresion");
	}
	}*/

	

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//initialise au chargement de la fenetre ou interface  mes differents controls
		bt_ok.setVisible(false);
		bt_ajout.setVisible(false);
		bt_suppr.setVisible(false);
		tx_1.setEditable(false);
		
		
		base= new ArrayList<Articles>();
        base1=FXCollections.observableArrayList();
        
		donne=new ConnBD();
		com=donne.connect();
		try {//interrogation et recuperation des informations de la base de donnee
			
			ResultSet sx=com.createStatement().executeQuery("SELECT * FROM articles;");
			
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
		
		//tcarte.setCellValueFactory(cellData-> cellData.getValue().getPropertyCarte().asObject());
		//table_carte.setCellValueFactory(new PropertyValueFactory<Client,Integer>("carte_fidele"));
		
		/*tcode.setCellValueFactory(new PropertyValueFactory<Client,String>("code"));
		tnom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
		tprenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
		tville.setCellValueFactory(new PropertyValueFactory<Client,String>("ville"));
		tdate.setCellValueFactory(new PropertyValueFactory<Client,String>("date"));*/
		
		tcode.setCellValueFactory(new PropertyValueFactory<Articles,String>("code"));
		tcodeC.setCellValueFactory(new PropertyValueFactory<Articles,String>("code_categorie"));
		tquan.setCellValueFactory(new PropertyValueFactory<Articles,Integer>("quantite"));
		tdesig.setCellValueFactory(new PropertyValueFactory<Articles,String>("designation"));
		tprix.setCellValueFactory(new PropertyValueFactory<Articles,Double>("prix_unitaire"));
	
		table.setItems(null);
		//table.setItems(base);
		
		table.setRowFactory( tv -> {
			   TableRow<Articles> row = new TableRow<>();
			   row.setOnMouseClicked(e -> {
			      if (e.getClickCount() == 2 && (!row.isEmpty()) ) {
			    	  
			    	/*  if(imp==1){

			    		  try {
			    	    stage = new Stage();
			  	        stage.setTitle("SARL INDIGO");
			  	        FXMLLoader loader = new FXMLLoader();
			  	        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Impression.fxml"));
			  	        AnchorPane page = (AnchorPane) loader.load();
							 Scene scene = new Scene(page);
					  	        //ImpressionControl control=loader.getController();
					  	       // control.setControl(this);
					  	     //  control.setclient(table.getSelectionModel().getSelectedItem());
					  	        stage.setScene(scene);
					  	        stage.initModality(Modality.WINDOW_MODAL);
					  	        stage.initOwner(exit);
					  	      
					  	        stage.showAndWait();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			  	       
			    	  }
			    	  if(imp==2) {
			    		  try {stage1 = new Stage();
				  	        stage1.setTitle("SARL INDIGO");
				  	        FXMLLoader loader = new FXMLLoader();
				  	        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Impression.fxml"));
				  	        AnchorPane page;
							
								page = (AnchorPane) loader.load();
								Scene scene = new Scene(page);
					  	        ImpressionControl control=loader.getController();
					  	     //   control.setControl1(this);
					  	     // control.setclient(table.getSelectionModel().getSelectedItem());
					  	        stage1.setScene(scene);
					  	        stage1.initModality(Modality.WINDOW_MODAL);
					  	        stage1.initOwner(exit);
					  	      
					  	        stage.showAndWait();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				  	        
			    	  }*/
			    	  person=table.getSelectionModel().getSelectedItem();
			    	critere=table.getSelectionModel().getSelectedItem().getCode();

			         try {
			        	edit(table.getSelectionModel().getSelectedItem());
					} catch (Exception  e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					                   }
			                      }
			      });
			   //person=table.getSelectionModel().getSelectedItem();
			   return row;
			});
		
		
		//table.setItems(base);
		//table.setVisible(false);
	
		cb.getItems().add("Code");
		cb.getItems().add("Code Categorie");
		
		cb.valueProperty().addListener(observable->  choix());
		
		
		
	}
	
	public void choix() {
		tx_1.setEditable(true);
		axe=cb.getSelectionModel().getSelectedItem().toString();
		if(axe.equals("CODE")) {
		tx_1.textProperty().addListener(observable -> length());
				
		}
		else {
			tx_1.textProperty().addListener(observable -> length1());
		}
	}
	
	public void length() {
		try{
			if(tx_1.getText().length()>6) {
				String t=tx_1.getText().substring(0,6);
				tx_1.setText(t);}
			}catch(IllegalArgumentException e) {
			
		}
	}
	public void length1() {
		try{
			if(tx_1.getText().length()>3) {
				String t=tx_1.getText().substring(0,6);
				tx_1.setText(t);}
			}catch(IllegalArgumentException e) {
			
		}
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
		ListIterator<Articles> li=base.listIterator();
		//int resul=0;
		Articles person=new Articles();
	
		while(li.hasNext()) {
			person=li.next();
		if(person.getCode().equals(tx_1.getText()) ||  person.CodeCategorie().equals(tx_1.getText())) 
			{
			base1.add(new Articles(person.getCode(),person.CodeCategorie(),person.getDesignation(),person.getQuantite(),person.getPrix_unitaire(),person.getDate()));
			}
			}
		if(!base1.isEmpty()) {
		lb_rien.setVisible(false);
		table.setItems(base1);
		table.setVisible(true);}else {
			table.setVisible(false);
			lb_rien.setVisible(true);
		}
		
		
}
	
	public void edit(Articles eret) {

		 rectangle.setVisible(true);
    	 lb_code.setVisible(true);
    	 lb_cc.setVisible(true);
    	 lb_desig.setVisible(true);
    	 lb_qu.setVisible(true);
    	 lb_date.setVisible(true);
    	 lb_prix.setVisible(true);
    
    	 tx_code.setText(eret.getCode());
    	 tx_cc.setText(eret.CodeCategorie());
    	 tx_prix.setText(""+eret.getPrix_unitaire());
    	 tx_qu.setText(""+eret.getQuantite());
    	 texte.setText(eret.getDesignation());
    	 tx_date.setText(eret.getDate());
    	 
    	 
    	 
    	 tx_code.setVisible(true);
    	 tx_cc.setVisible(true);   	 
    	 tx_qu.setVisible(true);
    	 tx_prix.setVisible(true);
    	 tx_date.setVisible(true);
    	 texte.setVisible(true);
    	
 			
     	 if(a==1) {
    		 bt_ok.setVisible(true);
    	 }else if(m==1) {
    		 bt_ajout.setVisible(true);
    	 }else {
    		 bt_suppr.setVisible(true);
    	 }
    	 
	}	
	
    @FXML	  			
	public void modifier() throws InterruptedException  {
		
		 
         try {//interrogation et recuperation des informations de la base de donnee
        	 
        	  stage=new Stage();
	         stage.setTitle(" Authentification System");
	         stage.getIcons().add(Img);
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(IarticleModifiControl.class.getResource("vue/VerifieArticle.fxml"));
	            AnchorPane anchor= (AnchorPane) loader.load();
	            Scene scene = new Scene(anchor);
	            stage.setScene(scene);
	            stage.initModality(Modality.WINDOW_MODAL);
		        stage.initOwner(refdeMod);
	         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
	            VerifieControl controller = loader.getController();
	            controller.setControl1(this);
	            stage.showAndWait();
	        
			if(su.equals("root") && pwd.equals("la7saintete")){
			donne=new ConnBD();
			com=donne.connect();
			try {
			com.createStatement().executeUpdate("UPDATE INTO articles set `code`='"+ tx_code.getText()+"',`code_categorie`='"+ tx_cc.getText()+"',`designation`='"+ texte.getText()+"',`quantite`="+tx_qu.getText()+",`prix_unitaire`="+ tx_prix.getText()+",current_date());");
			 Alert alert1 = new Alert(AlertType.INFORMATION);
			    alert1.initOwner(refdeMod);
			   alert1.setTitle("  Notification Systeme  ");
		        alert1.setContentText("Modification du Produit effectué");
		        alert1.showAndWait();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Probleme de  connexion a la base de donne");
			}
        	 
        	 
				// permet re recharger la page racine
			    main1.initialize(null, null);
			
		}else {
			
			Alert alert2 = new Alert(AlertType.WARNING);
	        alert2.initOwner(refdeMod);
	        alert2.setTitle("  Notification Systeme  ");
	        alert2.setHeaderText("");
	        alert2.setContentText("Vous n'avez pas l'autorisation pour effectuer cette oprération");
	        alert2.showAndWait();
		}
			}catch(Exception er) {
			
		}
         
		refdeMod.close();
    }
		
	@FXML
	public void supprimer() throws InterruptedException {
	
	
		 try {//interrogation et recuperation des informations de la base de donnee
			 // Nothing selected.
			 stage1=new Stage();
	         stage1.setTitle(" Authentification System");
	         stage1.getIcons().add(Img);
	        
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(IarticleModifiControl.class.getResource("vue/VerifieArticle.fxml"));
	            AnchorPane anchor= (AnchorPane) loader.load();
	            Scene scene = new Scene(anchor);
	            stage1.setScene(scene);
	            stage1.initModality(Modality.WINDOW_MODAL);
		        stage1.initOwner(refdeSupp);
	         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
	            VerifieControl controller = loader.getController();
	            controller.setControl2(this);
	            stage1.showAndWait();
	            if(su1.equals("root") && pwd1.equals("la7saintete")){
	    			donne=new ConnBD();
	    			com=donne.connect();
	    			try {
	    			com.createStatement().executeUpdate("DELETE FROM articles WHERE `code`='"+tx_code.getText()+"';");
	    			Alert alert2 = new Alert(AlertType.INFORMATION);
	    	        alert2.initOwner(refdeSupp);
	    	        alert2.setTitle("  Notification Systeme  ");
	    	        alert2.setHeaderText("");
	    	        alert2.setContentText("Suppresion effectuée");
	    	        alert2.showAndWait();
	    				} catch (SQLException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    				System.err.println("Probleme de  connexion a la base de donne");
	    			}
	            	 
	            	 
	    				// permet re recharger la page racine
	    			    main2.initialize(null, null);	
	                
	    		}else {
	    			
	    			Alert alert2 = new Alert(AlertType.WARNING);
	    	        alert2.initOwner(refdeSupp);
	    	        alert2.setTitle("  Notification Systeme  ");
	    	        alert2.setHeaderText("");
	    	        alert2.setContentText("Vous n'avez pas les autorisation pour effectuer cette oprération");
	    	        alert2.showAndWait();
	    		}
	    			}catch(Exception er) {
	    			
	    		}
	             
	    		refdeSupp.close();
			   
	}
	@FXML
	public void OK() {
		
		refdeRech.close();
	}
	@FXML
	public void annule() {
		
		try {
			refdeMod.close();
		}catch(Exception e) {
			try {
				refdeSupp.close();
				}catch(Exception  er){
					
				}
		}
	}
	
	
	public int loot(boolean ert) {
		int  r=0;
		if(ert==true) {
			r=1;
		}
		return r;
	}

	public boolean sensCarte(int a) {
		boolean ter=false;
		if(a==1) {
			ter=true;
		}
		return ter;
	}
	
	


}

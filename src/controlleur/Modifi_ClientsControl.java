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

import controlleur.donnee.Client;
import controlleur.donnee.ConnBD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Modifi_ClientsControl implements Initializable {

	
	private Iclient_MenuControl main,main1,main2,main3,main4;
	private Stage refdeMod,refdeSupp,refdeRech;
	private ConnBD donne;
	private ObservableList<Client> base1;
	private ArrayList<Client>base;
	private Connection com;
    private TableView<Client>OWN,own1;
	private String critere;
	
	
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
	private Button bt_rech,bt_ok,bt_suppr,bt_ajout;
	@FXML
	private Rectangle rectangle;
	@FXML
	private Label lb_new,lb_code,lb_nom,lb_prenom,lb_ville,lb_addresse,lb_email,lb_mobile,lb_tel_fixe,lb_remarque,lb_date,lb_codeP,lb_rien;
	
	
	private String axe;
	private int nbre,a=0,m=0,p=0;
	private Client person=new Client();
	
	
	
	
	
	public Modifi_ClientsControl() {
		
	}

public void setMod(Stage ert) {
	this.refdeMod=ert;
}
public void setSupp(Stage ert) {
	this.refdeSupp=ert;
}
public void setRech(Stage ert) {
	this.refdeRech=ert;
}

	/*public void  setTABLEVIEW(TableView<Client>A) {
		this.AZ=A;
	}*/
	
	public void setControl1(Iclient_MenuControl ert) {
		this.main=ert;
		a=1;
		try{	
	         	 lb_new.setText("Recherche de client dans le registre clientèle ");
	         	 insensible(carte);
	         	insensible(code);
	         	insensible(codeP);
	         	insensible(ville);
	         	insensible(nom);
	         	insensible(prenom);
	         	insensible(adresse);
	         	insensible(texte);
	         	insensible(mobile);
	         	insensible(tel);
	         	insensible(email);
	         	insensible(date);
		}catch(Exception eee) {
	 			System.err.println(" ERROR VERIFY YOUR FILE"); 	 	 		}
			
		
	}
	
	public void setControl2(Iclient_MenuControl ert) {
		this.main1=ert;
		m=1;
		 try{
			 OWN=main1.getTable();
	
	         	 lb_new.setText("Modification de client dans le registre clientèle ");
	         	insensible(code);
	         	 nom.setEditable(true);
	         	 prenom.setEditable(true);
	         	 ville.setEditable(true);
	         	 codeP.setEditable(true);
	         	 mobile.setEditable(true);
	         	 tel.setEditable(true);
	         	 email.setEditable(true);
	         	 adresse.setEditable(true);
	         	 texte.setEditable(true);
	         	
	         	 
	         	 date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	         	 date.setEditable(true);
	         	date.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
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
	     		});
	         	
	         	// bt_ajout.setVisible(true);
	         	}
	 		catch(Exception e) {System.err.println("ERROR ICI  modification");
	}}
	public void setControl3(Iclient_MenuControl ert) {
		this.main2=ert;
		 try{
	      
	         	 lb_new.setText("Suppresion  du client dans le registre clientèle");
	         	 own1=main2.getTable();
	         	 carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
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
	         		p=1;
	         	 //bt_suppr.setVisible(true);
	         	}
	 		catch(Exception er) { System.err.println("ERROR ICI  suppresion");
	}
	}
	/*public void setControl4(Iclient_MenuControl ert) {
		this.main3=ert;
		 try{
	         	exit2=main3.getStage5();
	         	 lb_new.setText("Aperçu Donnée Client avant Impression");
	         	 own1=main3.getTable();
	         	 carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
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
	         		imp=1;
	         	 //bt_suppr.setVisible(true);
	         	}
	 		catch(Exception er) { System.err.println("ERROR ICI  suppresion");
	}
	}
	public void setControl5(Iclient_MenuControl ert) {
		this.main4=ert;
		 try{
	         	exit2=main4.getStage6();
	         	 lb_new.setText("Impression du Client");
	         	 own1=main4.getTable();
	         	 carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
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

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//initialise au chargement de la fenetre ou interface  mes differents controls
		bt_ok.setVisible(false);
		bt_ajout.setVisible(false);
		bt_suppr.setVisible(false);
		
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
			    	  
			    	/*  if(imp==1){

			    		  try {refImp = new Stage();
			  	        stage.setTitle("SARL INDIGO");
			  	        FXMLLoader loader = new FXMLLoader();
			  	        loader.setLocation(Iclient_MenuControl.class.getResource("vue/Impression.fxml"));
			  	        AnchorPane page;
						
							page = (AnchorPane) loader.load();
							 Scene scene = new Scene(page);
					  	        ImpressionControl control=loader.getController();
					  	        control.setControl(this);
					  	       control.setclient(table.getSelectionModel().getSelectedItem());
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
					  	        control.setControl1(this);
					  	      control.setclient(table.getSelectionModel().getSelectedItem());
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
		
		table.setItems(null);
		//table.setItems(base);
		//table.setVisible(false);
	tx_1.setEditable(false);
		cb.getItems().add("CODE");
		cb.getItems().add("NOM");
		
		cb.valueProperty().addListener(observable->  choix());
		
		
		
	}
	
	public void choix() {
		tx_1.setEditable(true);
		axe=cb.getSelectionModel().getSelectedItem().toString();
		if(axe.equals("CODE")) {
		tx_1.textProperty().addListener(observable -> length());
				
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
			lb_rien.setVisible(false);
		table.setItems(base1);
		
			table.setVisible(true);}else {
			lb_rien.setVisible(true);
			table.setVisible(false);
		}
		
		
}
	
	public void edit(Client eret) {

		 rectangle.setVisible(true);
    	 lb_code.setVisible(true);
    	 lb_nom.setVisible(true);
    	 lb_prenom.setVisible(true);
    	 lb_ville.setVisible(true);
    	 lb_addresse.setVisible(true);
    	 lb_email.setVisible(true);
    	 lb_mobile.setVisible(true);
    	 lb_tel_fixe.setVisible(true);
    	 lb_remarque.setVisible(true);
    	 lb_date.setVisible(true);
    	 lb_codeP.setVisible(true);
    	 
    	 
    	 
    	 code.setText(eret.getCode());
    	 nom.setText(eret.getNom());
    	 prenom.setText(eret.getPrenom());
    	 carte.setSelected(sensCarte(eret.getCarteF()));
    	 ville.setText(eret.getVille());
    	 adresse.setText(eret.getAddresse());
    	 email.setText(eret.getEmail());
    	 mobile.setText(eret.getMobile());
    	 tel.setText(eret.getTel());
    	 texte.setText(eret.getRemarque());
    	 date.setText(eret.getDate());
    	 codeP.setText(eret.getCode_postal());
    	 
    	 
    	 code.setVisible(true);
    	 nom.setVisible(true);   	 
    	 prenom.setVisible(true);
    	 carte.setVisible(true);
    	 ville.setVisible(true);
    	 adresse.setVisible(true);
    	 email.setVisible(true);
    	 mobile.setVisible(true);
    	 tel.setVisible(true);
    	 texte.setVisible(true);
    	 date.setVisible(true);
    	 codeP.setVisible(true);

    	 
    	 carte.setOnMouseClicked(e-> {
 			if(e.getClickCount()<0) {
 				nbre=person.getCarteF();
 		}else {
 			nbre=loot(carte.selectedProperty().getValue().booleanValue());
 		}
 			
 	});
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
		/* personadd.setCode(code.getText());
		 System.err.println(person.getCode());
		 personadd.setNom(nom.getText());
		 personadd.setPrenom(prenom.getText());
		 personadd.setCarteF(nbre);
		 personadd.setAddresse(adresse.getText());
		 personadd.setCode_postal(codeP.getText());
		 personadd.setEmail(email.getText());
		 personadd.setMobile(mobile.getText());
		 personadd.setTel(tel.getText());
		 personadd.setRemarque(texte.getText());
		 personadd.setVille(ville.getText());
		 personadd.setDate(date.getText());*/
		 
         try {//interrogation et recuperation des informations de la base de donnee
        	 Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(refdeMod);
		        alert.setTitle("  Notification Systeme  ");
		        alert.setHeaderText("Mise à jour des Données Clients");
		        alert.setContentText("Souhaitez-vous effectuez la modification");
		        alert.showAndWait();
		        com.createStatement().executeUpdate("UPDATE clients SET `nom`='"+nom.getText()+"',`prenom`='"+prenom.getText()+"',`carte_fidele`="+nbre +",`date`=current_date() ,`addresse`='"+adresse.getText()+"',`code_postal`='"+codeP.getText()+"',`ville`='"+ville.getText() +"',`tel_fixe`='"+tel.getText()+"',`mobile`='"+mobile.getText()+"',`email`='"+email.getText()+"',`remarque`='"+texte.getText()+"' WHERE `code`='"+code.getText()+"';");
				// permet re recharger la page racine
			   main1.initialize(null, null);
			   Alert alert1 = new Alert(AlertType.CONFIRMATION);
			   alert1.setTitle("  Notification Systeme  ");
		        alert1.setContentText("Modification reussie");
		        alert1.showAndWait();
			
               } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Probleme de  connexion a la base de donne");
		}
		refdeMod.close();
    }
		
	@FXML
	public void supprimer() throws InterruptedException {
	
	
		 try {//interrogation et recuperation des informations de la base de donnee
			 // Nothing selected.
		        Alert alert = new Alert(AlertType.WARNING);
		        alert.initOwner(refdeSupp);
		        alert.setTitle("  Notification Systeme  ");
		        alert.setHeaderText("Souhaitez-vous supprimer le Client");
		        alert.setContentText("Cliquez pour supprimer");
		        alert.showAndWait();
			   com.createStatement().executeUpdate("DELETE FROM clients WHERE `code`='"+code.getText()+"';");
			   main2.initialize(null, null);
			   Thread.sleep(2000);
			   Alert alert1 = new Alert(AlertType.CONFIRMATION);
			   alert1.setTitle("  Notification Systeme  ");
		        alert1.setContentText("Suppresion reussie");
		        alert1.showAndWait();
			   
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Probleme de  connexion a la base de donne");
			}
		 refdeSupp.close();
	}
	@FXML
	public void OK() {
		
		refdeRech.close();
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
	
	public void insensible(TextField rt) {
		rt.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
 		    @Override
 		    public void handle(KeyEvent event) {
 		        event.consume();
 		    }
 		});
 		rt.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
 		    @Override
 		    public void handle(MouseEvent event) {
 		        event.consume();
 		    }
 		});
	}
	public void insensible(CheckBox rt) {
		rt.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
 		    @Override
 		    public void handle(KeyEvent event) {
 		        event.consume();
 		    }
 		});
 		rt.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
 		    @Override
 		    public void handle(MouseEvent event) {
 		        event.consume();
 		    }
 		});
	}
	public void insensible(TextArea rt) {
		rt.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
 		    @Override
 		    public void handle(KeyEvent event) {
 		        event.consume();
 		    }
 		});
 		rt.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
 		    @Override
 		    public void handle(MouseEvent event) {
 		        event.consume();
 		    }
 		});
	}
	
	
	

}

package controlleur;


import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import controlleur.donnee.Articles;
import controlleur.donnee.ConnBD;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IarticleAjoutControl {

	
	private ArticleMenu lien;
	private Articles own;
	private Stage refdeAjout,refdeInfo,stage,stage1;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	private boolean sens=false;
	
	//les controlleur utiliser par le controllleur
	
	@FXML
	private TextField tx_code,tx_cc,tx_qu,tx_pr,tx_date;
	@FXML
	private TextArea tx_dg;
	@FXML
	private ImageView iv_code,iv_cc,iv_qu,iv_pr;
	@FXML
	private Tooltip lae;
	@FXML
	private Label lb_info,lb_sig,lb_code,lb_cc,lb_dg,lb_date,lb_qu,lb_pr;
	@FXML
	private Button bt_ok,bt_annule,bt_connect;
	
	private ConnBD donne;
	private Connection com;
	int nbre=0;
	private String su,pwd;
	
	public IarticleAjoutControl() {
		
	}
	
	
	
	
	public void SensAuthentiq(String e,String r) {
		this.su=e;
		this.pwd=r;
	}
	
	public Stage getStage() {
		return stage;
	}
	public void setcontrol1(ArticleMenu ert) {
		this.lien=ert;
	}
	public void setAjout(Stage ert) {
		this.refdeAjout=ert;
	}
	public void setInfo(Stage ert) {
		this.refdeInfo=ert;
	}
	
	public void setClient(Articles rte) {
		
try {
	this.own=rte;
	lb_sig.setText("Information Article");
	
	tx_code.setText(own.getCode());
	tx_cc.setText(own.CodeCategorie());
	tx_dg.setText(own.getDesignation());
	tx_qu.setText(""+own.getQuantite());
	tx_date.setText(own.getDate());
	tx_pr.setText(""+own.getPrix_unitaire());
	insensible(tx_code);
	insensible(tx_cc);
	insensible(tx_qu);
	insensible(tx_pr);
	insensible(tx_date);
	insensible(tx_dg);
	bt_ok.setVisible(true);
		
}catch(Exception e) {
	tx_date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	lb_sig.setText("Ajout Nouvel Article");
	bt_connect.setVisible(true);
	bt_annule.setVisible(true);
}
	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			
			
		iv_code.setVisible(false);
		iv_cc.setVisible(false);
		iv_qu.setVisible(false);
		iv_pr.setVisible(false);
		lb_info.setVisible(false);
		//gestion d'erreur sur le nombre de caractere a saisir
		tx_code.textProperty().addListener(observable -> length());
		tx_cc.textProperty().addListener(observable -> length1());
		
		
		//gestion d'erreur sur le code a saisir
		
		lb_sig.setText("");
		
		bt_ok.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
			
			
	});

		bt_annule.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
			
			
	});

		bt_connect.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
			
			
	});
		/*ch_carte.setOnMouseClicked(e-> {
			if(e.getClickCount()<0) {
				nbre=0;
		}else {
			nbre=loot(ch_carte.selectedProperty().getValue().booleanValue());
		}
			
	});*/
		
		
}
	public void length() {
		try{
			if(tx_code.getText().length()>6) {
				String t=tx_code.getText().substring(0,6);
				tx_code.setText(t);}
			}catch(IllegalArgumentException e) {
			
		}
	}
	public void length1() {
		try{
			if(tx_cc.getText().length()>3) {
				String t=tx_code.getText().substring(0,3);
				tx_code.setText(t);}
			}catch(IllegalArgumentException e) {
			
		}
	}
	
	@FXML
	public void ajouteNewArticle() throws Exception  {
	//	table1=lien.getTable();
		
		if(vide()) {
			stage=new Stage();
	         stage.setTitle("Editer le Produit");
	         stage.getIcons().add(img);
	           // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(IarticleAjoutControl.class.getResource("vue/VerifieArticle.fxml"));
	            AnchorPane anchor= (AnchorPane) loader.load();
	            Scene scene = new Scene(anchor);
	            stage.setScene(scene);
	            stage.initModality(Modality.WINDOW_MODAL);
		        stage.initOwner(refdeAjout);
	         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
	            VerifieControl controller = loader.getController();
	            controller.setControl(this);
	            stage.showAndWait();
	        
			if(su.equals("root") && pwd.equals("la7saintete")){
			donne=new ConnBD();
			com=donne.connect();
			try {
			com.createStatement().executeUpdate("insert into articles values('"+ tx_code.getText()+"','"+ tx_cc.getText()+"','"+ tx_dg.getText()+"','"+tx_qu.getText()+"','"+ tx_pr.getText()+"',current_date());");
			 Alert alert1 = new Alert(AlertType.INFORMATION);
		        alert1.initOwner(stage);
		        alert1.setTitle("  Notification Systeme  ");
		        alert1.setHeaderText("");
		        alert1.setContentText("Enregistrement reussit");
		        alert1.showAndWait();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Probleme de  connexion a la base de donne");
			}
			}
			else{
				
				 Alert alert = new Alert(AlertType.WARNING);
			        alert.initOwner(stage1);
			        alert.setTitle("  Notification Systeme  ");
			        alert.setHeaderText("");
			        alert.setContentText("Vous n'etes pas autorisé a effectuer cette operation");
			        alert.showAndWait();
			}
			lien.initialize(null, null);
			refdeAjout.close();
			
		}else {
				if(tx_code.getText().isEmpty()) {
					iv_code.setVisible(true);
					
				}
				if(tx_cc.getText().isEmpty()) {
					iv_cc.setVisible(true);
				}
				if(tx_qu.getText().isEmpty()) {
					iv_qu.setVisible(true);
				}
				
				if(tx_pr.getText().isEmpty()) {
					iv_pr.setVisible(true);
				}
				
				lb_info.setVisible(true);
				
			}
		
		}
	
	private boolean vide() {
		if(!tx_code.getText().isEmpty()  && !tx_cc.getText().isEmpty() && !tx_qu.getText().isEmpty() && !tx_pr.getText().isEmpty()) {
			sens=true;
		}
			return sens;
	}
	
	@FXML
	public void ok() {
		refdeInfo.close();
	}
	@FXML
	public void efface() {
		refdeAjout.close();
	}
	@FXML
	public  void senscode() {
		iv_code.setVisible(false);
		lb_info.setVisible(false);
		
	}

	@FXML
	public  void sensCc() {
		iv_cc.setVisible(false);
		lb_info.setVisible(false);
	}
	@FXML
	public  void Qu() {
		iv_qu.setVisible(false);
		lb_info.setVisible(false);
	}
	@FXML
	public  void Prix() {
		iv_pr.setVisible(false);
		lb_info.setVisible(false);
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

package controlleur;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;



import controlleur.donnee.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IclientAjoutControl implements Initializable {
	
	
	private Iclient_MenuControl lien;
	private Client own;
	private Stage refdeAjout,refdeInfo;

	private ArrayList<String>list=new ArrayList<String>();
	
	
	//les controlleur utiliser par le controllleur
	
	@FXML
	private TextField tx_code;
	@FXML
	private TextField tx_nom;
	@FXML
	private TextField tx_prenom;
	@FXML
	private TextField tx_addresse;
	@FXML
	private TextField tx_code_postal;
	@FXML
	private TextField tx_ville;
	@FXML
	private TextField tx_mobile;
	@FXML
	private TextField tx_tel_fixe;
	@FXML
	private TextArea tx_remarque;
	@FXML
	private TextField tx_date;
	@FXML
	private TextField tx_email;
	@FXML
	private CheckBox ch_carte;
	@FXML
	private ImageView iv_code;
	@FXML
	private ImageView iv_nom;
	@FXML
	private ImageView iv_prenom;
	@FXML
	private ImageView iv_ville;
	@FXML
	private ImageView iv_mobile;
	@FXML
	private Tooltip lae;
	@FXML
	private Label lb_info,lb_e,lb_sig,lb_error;
	@FXML
	private Button bt_ok,bt_annule,bt_connect;
	
	private ConnBD donne;
	private Connection com;
	int nbre=0;
	
	public IclientAjoutControl() {
		
	}
	
	public void setCodeList(ArrayList<String> ert) {
		this.list=ert;
	}
	
	public void setcontrol1(Iclient_MenuControl ert) {
		this.lien=ert;
	}
	public void setAjout(Stage ert) {
		try{
			this.refdeAjout=ert;
			tx_date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			lb_sig.setText("Ajout Nouvel CLIENT");
		}catch(Exception er) {
			
		}
	}
	public void setInfo(Stage ert) {
		this.refdeInfo=ert;
	}
	
	public void setClient(Client rte) {
		this.own=rte;
try {
	lb_sig.setText("Information Client");
	tx_code.setText(own.getCode());
	tx_code.setEditable(false);
	
	tx_nom.setText(own.getNom());
	tx_nom.setEditable(false);
	
	tx_prenom.setText(own.getPrenom());
	tx_prenom.setEditable(false);
	
	tx_ville.setText(own.getVille());
	tx_ville.setEditable(false);
	
	tx_date.setText(own.getDate());
	
	tx_mobile.setText(own.getMobile());
	tx_mobile.setEditable(false);
	
	tx_tel_fixe.setText(own.getTel());
	tx_tel_fixe.setEditable(false);
	
	ch_carte.setSelected(sensCarte(own.getCarteF()));
	;
	
	ch_carte.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent event) {
	        event.consume();
	    }
	});
	ch_carte.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
	    @Override
	    public void handle(MouseEvent event) {
	        event.consume();
	    }
	});
	
	tx_addresse.setText(own.getAddresse());
	tx_addresse.setEditable(false);
	
	tx_email.setText(own.getEmail());
	tx_email.setEditable(false);
	
	tx_code_postal.setText(own.getCode_postal());
	tx_code_postal.setEditable(false);
	
	tx_remarque.setText(own.getRemarque());
	tx_remarque.setEditable(false);
	bt_ok.setVisible(true);
	bt_connect.setVisible(false);
	bt_annule.setVisible(false);
	

	
}catch(Exception e) {
	
}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
			
			
		iv_nom.setVisible(false);
		iv_code.setVisible(false);
		iv_ville.setVisible(false);
		iv_prenom.setVisible(false);
		iv_mobile.setVisible(false);
		lb_info.setVisible(false);
		tx_code.textProperty().addListener(observable -> length());
		tx_code.textProperty().addListener(observable -> verifie());
		lb_sig.setText("");
		
		
		bt_ok.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
			
	});

		ch_carte.setOnMouseClicked(e-> {
			if(e.getClickCount()<0) {
				nbre=0;
		}else {
			nbre=loot(ch_carte.selectedProperty().getValue().booleanValue());
		}
			
	});
		
		
		bt_connect.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		bt_annule.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		
	
}
	public void length() {
		try{
			if(tx_code.getText().length()>6) {
				String t=tx_code.getText().substring(0,6);
				tx_code.setText(t);
			}
			}catch(IllegalArgumentException e) {}
		
	}
	
	public void verifie() {
		try {
		
		if(list.contains(tx_code.getText())) {
			iv_code.setVisible(true);
			lb_error.setVisible(true);
		}
		else {
				iv_code.setVisible(false);
					lb_error.setVisible(false);
		}}catch(Exception r) {
			
		}
	}
	
	@FXML
	public void ajouteNewClient()  {
		
		if(vide()) {
			
			donne=new ConnBD();
			com=donne.connect();
			try {
			com.createStatement().executeUpdate("insert into clients values('"+ tx_code.getText()+"','"+ tx_nom.getText()+"','"+ tx_prenom.getText()+"',"+nbre+",current_date(),'"+tx_addresse.getText()+"','"+ tx_code_postal.getText()+"','"+tx_ville.getText()+"','"+ tx_tel_fixe.getText()+"','"+tx_mobile.getText()+"','"+ tx_email.getText()+"','"+ tx_remarque.getText()+"');");
				
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println("Probleme de  connexion a la base de donne");
			}
			
			lien.initialize(null, null);
			Alert alert2 = new Alert(AlertType.INFORMATION);
	        alert2.initOwner(refdeAjout);
	        alert2.setTitle("  Notification Systeme  ");
	        alert2.setHeaderText("");
	        alert2.setContentText("Enregistrement effectuez avec succès");
	        alert2.showAndWait();
			refdeAjout.close();
			
		}else {
				if(tx_code.getText().isEmpty()) {
					iv_code.setVisible(true);
				}
				if(tx_nom.getText().isEmpty()) {
					iv_nom.setVisible(true);
				}
				if(tx_prenom.getText().isEmpty()) {
					iv_prenom.setVisible(true);
				}
				
				if(tx_ville.getText().isEmpty()) {
					iv_ville.setVisible(true);
				}
				if(tx_mobile.getText().isEmpty()) {
					iv_mobile.setVisible(true);
				}
				lb_info.setVisible(true);
				
			}
		
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
	public  void sensnom() {
		iv_nom.setVisible(false);
		lb_info.setVisible(false);
	}
	@FXML
	public  void sensville() {
		iv_ville.setVisible(false);
		lb_info.setVisible(false);
	}
	@FXML
	public  void sensmobile() {
		iv_mobile.setVisible(false);
		lb_info.setVisible(false);
	}
	@FXML
	public  void sensprenom() {
		iv_prenom.setVisible(false);
		lb_info.setVisible(false);
	}

public boolean sensCarte(int a) {
	boolean ter=false;
	if(a==1) {
		ter=true;
	}
	return ter;
}
public boolean vide() {
	boolean choix=false;
	if(!tx_code.getText().isEmpty() && !tx_nom.getText().isEmpty() && !tx_prenom.getText().isEmpty() && !tx_mobile.getText().isEmpty() && !tx_ville.getText().isEmpty() && !lb_error.isVisible() ) {
		choix=true;
	}
	
	return choix;
}
public int loot(boolean ert) {
	int  r=0;
	if(ert==true) {
		r=1;
	}
	return r;
}

//ces differentes methode sert a fait l'action du focu dans les champs








}
	

package controlleur;

import java.net.URL;
import java.util.ResourceBundle;
import controlleur.donnee.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class IclientAjoutControl implements Initializable {
	private Iclient_MenuControl lien;
	private TableView<Client> table1;
	
	
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
	private TextField tx_remarque;
	@FXML
	private TextField tx_date;
	@FXML
	private TextField tx_email;
	@FXML
	private CheckBox ch_carte_fidele;
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
	private Label lb_info;
	
	public IclientAjoutControl() {
		
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
		
	}
	
	public void setcontrol1(Iclient_MenuControl eres) {
		this.lien=eres;
	}
	@FXML
	public void ajouteNewClient() {
		table1=lien.getTable();
		if(vide()) {
			//table1.add(new Client(tx_code.getText(),tx_nom.getText(),tx_prenom.getText(),tx_ville.getText(),tx_code_postal.getText(),tx_addresse.getText(),tx_mobile.getText(),tx_email.getText(),tx_remarque.getText(),tx_tel_fixe.getText(),loot(ch_carte_fidele.selectedProperty().get()),tx_code.getText(),))
		}
	}

public boolean vide() {
	boolean choix=false;
	if(!tx_code.getText().isEmpty() && tx_nom.getText().isEmpty() && !tx_prenom.getText().isEmpty() && !tx_mobile.getText().isEmpty() && !tx_ville.getText().isEmpty() ) {
		choix=true;
	}
	else {
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
	return choix;
}
public int loot(boolean ert) {
	int  r=0;
	if(ert=true) {
		r=1;
	}
	return r;
}

//ces differentes methode sert a fait l'action du focu dans les champs
@FXML
public  void senscode() {
	iv_code.setVisible(false);
	lb_info.setVisible(false);
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







}
	

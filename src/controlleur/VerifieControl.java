package controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerifieControl implements Initializable{
	
	private IarticleAjoutControl main;
	private IarticleModifiControl main1,main2;
	
	
	@FXML
	private Button ok,annule;
	@FXML
	private TextField pwd,user;
	
public VerifieControl() {
	
}


public void setControl(IarticleAjoutControl ert) {
	this.main=ert;
}

public void setControl1(IarticleModifiControl ert) {
	this.main1=ert;
}
public void setControl2(IarticleModifiControl ert) {
	this.main2=ert;
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
}

@FXML
public void OK() {
	try {
		main.SensAuthentiq(user.getText(), pwd.getText());
		Stage stage=main.getStage();
		stage.close();
	}catch(Exception e) {
		try {
			main1.setvaleur(user.getText(), pwd.getText());
			Stage stage=main1.getStage();
			stage.close();
		}catch(Exception ee) {
			try {
				main2.setvaleur1(user.getText(), pwd.getText());
				Stage stage=main2.getStage1();
				stage.close();
			}catch(Exception eTe) {
				
			}
		}
	}
	
	
	
	}
@FXML
public void annule() {
	try {
		main.SensAuthentiq(null, null);
		Stage stage=main.getStage();
		stage.close();
	}catch(Exception e) {
		try{
			main1.setvaleur(null, null);
			Stage stage1=main1.getStage();
			stage1.close();
		}catch(Exception eE){
			try{
				main2.setvaleur1(null, null);
				Stage stage2=main2.getStage1();
				stage2.close();
			}catch(Exception Re){
				}
		}
	
	
		}
	
	
}




}

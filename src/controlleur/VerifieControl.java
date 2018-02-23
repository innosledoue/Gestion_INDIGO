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
	
	@FXML
	private Button ok,annule;
	@FXML
	private TextField pwd,user;
	
public VerifieControl() {
	
}


public void setControl(IarticleAjoutControl ert) {
	this.main=ert;
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	// TODO Auto-generated method stub
	
}

public void OK() {
	main.SensAuthentiq(user.getText(), pwd.getText());
	Stage stage=main.getstage();
	stage.close();
	}

public void annule() {
	main.SensAuthentiq(null, null);
}

}

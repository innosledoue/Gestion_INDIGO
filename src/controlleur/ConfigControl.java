package controlleur;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConfigControl implements Initializable{
private Stage refdeConfig,refMenu;
private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	public ConfigControl() {
		
	}
	
	public void setConfig(Stage ert) {
		this.refdeConfig=ert;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void Menu() throws Exception {
		refMenu= new Stage();
        refMenu.setTitle("SARL INDIGO");
        refMenu.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ConfigControl.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setMenu5(refMenu);
        		
        Scene scene = new Scene(page);
        refMenu.setScene(scene);
        refMenu.show();
        refdeConfig.close();
	}

}

package controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IcommandeControl implements Initializable {

	private Stage refdeCommande,refMenu;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	public IcommandeControl() {
		
	}
	
	
	
	public void setCommande(Stage ert) {
	this.refdeCommande=ert;
		}
	
	@FXML
	public void Menu() throws IOException {
		
		refMenu= new Stage();
        refMenu.setTitle("SARL INDIGO");
        refMenu.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(IcommandeControl.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setMenu3(refMenu);
        Scene scene = new Scene(page);
        refMenu.setScene(scene);
        refMenu.show();
        refdeCommande.close();
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}

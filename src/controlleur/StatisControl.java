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

public class StatisControl implements Initializable{
	private Stage refdeStatis,refMenu;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	
	public StatisControl() {
		
	}
	
	public void setStatis(Stage ert) {
		this.refdeStatis=ert;
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
        loader.setLocation(StatisControl.class.getResource("vue/MenuApp.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        MenuControl controller = loader.getController();
		controller.setMenu4(refMenu);
        		
        Scene scene = new Scene(page);
        refMenu.setScene(scene);
        refMenu.show();
        refdeStatis.close();
	}

}

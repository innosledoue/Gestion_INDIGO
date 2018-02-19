package controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;




public class MenuControl implements Initializable {
	
	private Stage stage;
  	private IconnectControl main;
  	
	@FXML
	private Button cli;
	@FXML
	private Button com;
	@FXML
	private Button art;
	@FXML
	private Button sta;
	@FXML
	private Button par;
	@FXML
	private Tooltip tip_cli ;
	@FXML
	private Tooltip tip_com;
	@FXML
	private Tooltip tip_art;
	@FXML
	private Tooltip tip_sta;
	@FXML
	private Tooltip tip_par;
	
	
	
	public MenuControl() {	
	}
	
	public Stage getStage() {
		return this.stage;
		}
	
	public void setControl(IconnectControl ter) {
		this.main=ter;
				}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	
		
	}
	
	
    
	
	@FXML
	public void clientApp() throws Exception {
		Stage exit=main.getStage();
		
		Stage stage = new Stage();
         stage.setTitle("SARL INDIGO");
         
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuControl.class.getResource("vue/Iclient_Menu.fxml"));
            AnchorPane anchor= (AnchorPane) loader.load();
            Scene scene = new Scene(anchor);
            stage.setScene(scene);
                      
         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
            Iclient_MenuControl controller = loader.getController();
            controller.setControl(this);
            
            //ouverture de la fenetre Iclient_Menu et fermeture de celle ci
            stage.show(); 
            exit.close();
      
        
	}
	@FXML
	public void commandeApp() throws Exception {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        stage.show();   
        exit.close();
        
	}
	@FXML
	public void articleApp() throws Exception {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        
        stage.show();
        exit.close();
	}
	@FXML
	public void statistqueApp() throws IOException {
		Stage exit=main.getStage();
		Stage stage = new Stage();
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        stage.show();
       exit.close();
	}
	@FXML
	public void parametreApp() throws IOException {
		Stage exit=main.getStage();
		Stage stage = new Stage();
		
        stage.setTitle("SARL INDIGO");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
         stage.show(); 
         exit.close();
     
	}
	
	// loader.setLocation(IconnectControl.class.getResource("vue/IclientPresent.fxml"));
    // AnchorPane sub=(AnchorPane) loader.load();
     // AnchorPane.setTopAnchor(sub,0.0);
      //AnchorPane.setTopAnchor(button, 10.0); 
     // AnchorPane.setLeftAnchor(button, 10.0); 
     // AnchorPane.setRightAnchor(button, 65.0);
      // Show the scene containing the root layout.
    
	//stage.initModality(Modality.WINDOW_MODAL);
    //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
	//stage.initModality(Modality.WINDOW_MODAL);
    //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
	//stage.initModality(Modality.WINDOW_MODAL);
    //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
	//stage.initModality(Modality.WINDOW_MODAL);
    //stage.initOwner(((Node) event.getSource()).getScene().getWindow());
	//etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
    //IconnectControl controller = loader.getController();
   // controller.setControl(this);
	 //choix=controller.getboolean();
    //stage.initModality(Modality.WINDOW_MODAL);
//stage.initOwner(((Node) event.getSource()).getScene().getWindow());

	
	
	
}

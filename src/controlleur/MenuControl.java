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
	
	private Stage stage,stage1,stage2,stage3,stage4;
	private Stage exit;
  	private IconnectControl main;
  	Iclient_MenuControl main1;
  	
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
	public Stage getStage1() {
		return this.stage1;
		}
	public Stage getStage2() {
		return this.stage2;
		}
	public Stage getStage3() {
		return this.stage3;
		}
	public Stage getStage4() {
		return this.stage4;
		}
	
	
	
	
	public void setControl(IconnectControl ter) {
		this.main=ter;
						}
	public void setControl(Iclient_MenuControl ter) {
		this.main1=ter;
		
				}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		cli.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		com.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		par.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		sta.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		art.setOnMouseClicked(e-> {
			if(e.getClickCount()>=2) {
				e.consume();
		}
	});
		
	}
	
	
    
	
	@FXML
	public void clientApp() throws Exception {
		
	 stage=new Stage();
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
            
            try{
            	exit=main.getStage();
            	 exit.close();
            	}
    		catch(NullPointerException e) {
    		exit=main1.getstage7();	
    		 exit.close();
    		}
     
        
	}
	@FXML
	public void commandeApp() throws Exception {
		Stage exit=main.getStage();
		stage1=new Stage();
        stage1.setTitle("SARL INDIGO");
        stage1.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        stage1.show();   
        exit.close();
        
	}
	@FXML
	public void articleApp() throws Exception {
		Stage exit=main.getStage();
		stage2=new Stage();
		stage2 = new Stage();
        stage2.setTitle("SARL INDIGO");
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        
        stage2.show();
        exit.close();
	}
	@FXML
	public void statistqueApp() throws IOException {
		Stage exit=main.getStage();
		stage3=new Stage();
        stage3.setTitle("SARL INDIGO");
        stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
        stage3.show();
       exit.close();
	}
	@FXML
	public void parametreApp() throws IOException {
		Stage exit=main.getStage();
		stage4=new Stage();
		
        stage4.setTitle("SARL INDIGO");
        stage4.setScene(new Scene(FXMLLoader.load(getClass().getResource("vue/MenuApp.fxml"))));
         stage4.show(); 
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

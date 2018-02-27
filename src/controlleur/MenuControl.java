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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;




public class MenuControl implements Initializable {
	
	private Stage refClient,refCommande,refArticle,refStatis,refConfig,refConnect;
	private Stage refdeMenu,refdeMenuCl,refdeMenuC,refdeMenuA,refdeMenuS,refdeMenuCf;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
  	
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
	
	
	
	
	public void setMenu(Stage ter) {
		this.refdeMenu=ter;
						}
	
	public void setMenu1(Stage ter) {
		this.refdeMenuCl=ter;
						}
	public void setMenu2(Stage ter) {
		this.refdeMenuA=ter;
						}
	public void setMenu3(Stage ter) {
		this.refdeMenuC=ter;
						}
	public void setMenu4(Stage ter) {
		this.refdeMenuS=ter;
	}
	public void setMenu5(Stage ter) {
		this.refdeMenuCf=ter;
	}
	
	
	public void setMenuclient(Stage ter) {
		this.refdeMenuCl=ter;
	
				}
	public void setMenuComm(Stage ter) {
		this.refdeMenuC=ter;
				}
	public void setMenuArticle(Stage ter) {
		this.refdeMenuA=ter;
		
				}
	public void setMenuConfig(Stage ter) {
		this.refdeMenuCf=ter;
				}
	public void setMenuStatis(Stage ter) {
		this.refdeMenuS=ter;
		
				}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

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
		
	     refClient=new Stage();
         refClient.setTitle("SARL INDIGO");
         refClient.getIcons().add(img);
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuControl.class.getResource("vue/Iclient_Menu.fxml"));
            AnchorPane anchor= (AnchorPane) loader.load();
            Scene scene = new Scene(anchor);
            refClient.setScene(scene);
         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
            Iclient_MenuControl controller = loader.getController();
            controller.setClient(refClient);
            //ouverture de la fenetre Iclient_Menu et fermeture de celle ci
            refClient.show(); 
            try{
            	
          	refdeMenu.close();
          	}
    		catch(Exception e ) {
    			try {
    				refdeMenuCl.close();
    			}catch(Exception ee) {
    				try {
    					refdeMenuC.close();
    				}catch(Exception ze) {
    					try{
    						refdeMenuA.close();
    					}catch(Exception es) {
    						try{
    							refdeMenuS.close();
    						}catch(Exception er) {
    							refdeMenuCf.close();
    						}
    					}
    				}
    			}

    		
    		}
            
    		}
     
        
	
	@FXML
	public void commandeApp() throws Exception {
		
		refCommande=new Stage();
        refCommande.setTitle("SARL INDIGO");
        refCommande.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuControl.class.getResource("vue/Icommandes.fxml"));
        AnchorPane anchor1= (AnchorPane) loader.load();
        Scene scene = new Scene(anchor1);
        refCommande.setScene(scene);
        IcommandeControl controller = loader.getController();
        controller.setCommande(refCommande);
               
        	refCommande.show(); 
        	try{
            	
              	refdeMenu.close();
              	}
        		catch(Exception e ) {
        			try {
        				refdeMenuCl.close();
        			}catch(Exception ee) {
        				try {
        					refdeMenuC.close();
        				}catch(Exception ze) {
        					try{
        						refdeMenuA.close();
        					}catch(Exception es) {
        						try{
        							refdeMenuS.close();
        						}catch(Exception er) {
        							refdeMenuCf.close();
        						}
        					}
        				}
        			}
        			}

        		
        
	}
	@FXML
	public void articleApp() throws Exception {
		 refArticle=new Stage();
         refArticle.setTitle("SARL INDIGO");
         refArticle.getIcons().add(img);
           // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MenuControl.class.getResource("vue/Fen_Articles.fxml"));
            AnchorPane anchor2= (AnchorPane) loader.load();
            Scene scene = new Scene(anchor2);
            refArticle.setScene(scene);         
         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
            ArticleMenu controller = loader.getController();
            controller.setArticle(refArticle);
            //ouverture de la fenetre Iclient_Menu et fermeture de celle ci
            refArticle.show();
            try{
            	
              	refdeMenu.close();
              	}
        		catch(Exception e ) {
        			try {
        				refdeMenuCl.close();
        			}catch(Exception ee) {
        				try {
        					refdeMenuC.close();
        				}catch(Exception ze) {
        					try{
        						refdeMenuA.close();
        					}catch(Exception es) {
        						try{
        							refdeMenuS.close();
        						}catch(Exception er) {
        							refdeMenuCf.close();
        						}
        					}
        				}
        			}
        			}

        		
	}
	@FXML
	public void statistqueApp() throws IOException {
		refStatis=new Stage();
        refStatis.setTitle("SARL INDIGO");
        refStatis.getIcons().add(img);
     // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuControl.class.getResource("vue/Istatistique.fxml"));
        AnchorPane anchor3= (AnchorPane) loader.load();
        Scene scene = new Scene(anchor3);
        refStatis.setScene(scene);         
     // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
        StatisControl controller = loader.getController();
        controller.setStatis(refStatis);
        //ouverture de la fenetre Iclient_Menu et fermeture de celle ci
       refStatis.show();
        try{
        	
          	refdeMenu.close();
          	}
    		catch(Exception e ) {
    			try {
    				refdeMenuCl.close();
    			}catch(Exception ee) {
    				try {
    					refdeMenuC.close();
    				}catch(Exception ze) {
    					try{
    						refdeMenuA.close();
    					}catch(Exception es) {
    						try{
    							refdeMenuS.close();
    						}catch(Exception er) {
    							refdeMenuCf.close();
    						}
    					}
    				}
    			}

    		
		}

	}
	@FXML
	public void parametreApp() throws IOException {
		refConfig=new Stage();
        refConfig.setTitle("SARL INDIGO");
        refConfig.getIcons().add(img);
     // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MenuControl.class.getResource("vue/Iconfiguration.fxml"));
        AnchorPane anchor4= (AnchorPane) loader.load();
        Scene scene = new Scene(anchor4);
        refConfig.setScene(scene);         
     // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
        ConfigControl controller = loader.getController();
        controller.setConfig(refConfig);
        //ouverture de la fenetre Iclient_Menu et fermeture de celle ci
       refConfig.show();
        try{
        	
          	refdeMenu.close();
          	}
    		catch(Exception e ) {
    			try {
    				refdeMenuCl.close();
    			}catch(Exception ee) {
    				try {
    					refdeMenuC.close();
    				}catch(Exception ze) {
    					try{
    						refdeMenuA.close();
    					}catch(Exception es) {
    						try{
    							refdeMenuS.close();
    						}catch(Exception er) {
    							refdeMenuCf.close();
    						}
    					}
    				}
    			}

    		}
	}
	@FXML
	public void verrou() throws Exception {
		
		refConnect=new Stage();
        refConnect.setTitle("SARL INDIGO");
        refConnect.getIcons().add(img);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("vue/Iconnect.fxml"));
        AnchorPane anchor1= (AnchorPane) loader.load();
        Scene scene = new Scene(anchor1);
        refConnect.setScene(scene);
        IconnectControl controller = loader.getController();
        controller.setConnect1(refConnect);
               
        	refConnect.show(); 
        	try{
            	
              	refdeMenu.close();
              	}
        		catch(Exception e ) {
        			try {
        				refdeMenuCl.close();
        			}catch(Exception ee) {
        				try {
        					refdeMenuC.close();
        				}catch(Exception ze) {
        					try{
        						refdeMenuA.close();
        					}catch(Exception es) {
        						try{
        							refdeMenuS.close();
        						}catch(Exception er) {
        							refdeMenuCf.close();
        						}
        					}
        				}
        			}
        			}

        		
        
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

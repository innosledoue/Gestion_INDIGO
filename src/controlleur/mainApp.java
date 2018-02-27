package controlleur;





import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class mainApp extends Application {

	private Stage stage;
	private AnchorPane anchor;
	private Image img=new Image(getClass().getResourceAsStream("image.png"));
	
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
        stage.setTitle("SARL INDIGO");
        stage.getIcons().add(img);
        affiche();
	}
	
	private void affiche() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("vue/Iconnect.fxml"));
            anchor= (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchor);
            stage.setScene(scene);
            stage.show();
            
         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
            IconnectControl controller = loader.getController();
            controller.setConnect(stage);
            //choix=controller.getboolean();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}


package controlleur;





import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class mainApp extends Application {

	private Stage stage;
	private AnchorPane anchor;
	
	public Stage getStage() {
		return this.stage;
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
        this.stage.setTitle("SARL INDIGO");
        // place icon de l'application
        affiche();
	}
	
	private void affiche() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(mainApp.class.getResource("vue/Iconnect.fxml"));
            anchor= (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(anchor);
            stage.setScene(scene);
            stage.show();
            
         // etablie une connexion  de IconnectControl(le controleur) avec le mainApp.
            IconnectControl controller = loader.getController();
            controller.setControl(this);
            //choix=controller.getboolean();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public static void main(String[] args) {
		launch(args);
	}
}


package assignmentgui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoadGui {

	public LoadGui() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	public void loadTemplateFXML(String fxmlFile) throws IOException {
		AnchorPane MainPage;
		Stage primaryStage = new Stage();
		MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource(fxmlFile));
		Scene MainPageScene = new Scene(MainPage,1100,800);
		MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(MainPageScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}

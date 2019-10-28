package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainPageController implements Initializable {
	
	
	
	public MainPageController() {

		
	}
	
	public void initialize(URL url, ResourceBundle rb) {
	
		
	}
	
	@FXML
	public void ViewSingle(ActionEvent event) throws IOException {
		
		AnchorPane MainPage;
		Stage primaryStage = new Stage();
		MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("SinglePage.fxml"));
		Scene MainPageScene = new Scene(MainPage); 
		MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(MainPageScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
}

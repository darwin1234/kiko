package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {
	//@FXML
	//private AnchorPane MainPage;
	
	public LoginController() {

		
	}
	
	public void initialize() {
		
	}
	
	@FXML
	public void ProceedLogin(ActionEvent event) throws IOException {
		AnchorPane MainPage;
		Stage primaryStage = new Stage();
		MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
		Scene MainPageScene = new Scene(MainPage,1100,800);
		MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(MainPageScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
		
	
	@FXML
	public void SignUpPage(ActionEvent event) {
		try {
			AnchorPane MainPage;
			Stage primaryStage = new Stage();
			MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene MainPageScene = new Scene(MainPage,830,460);
			MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(MainPageScene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
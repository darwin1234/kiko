package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	public TextField usernamefield;

	
	public TextField passwordfield;
	

	
	@FXML
	public void ProceedLogin(ActionEvent event) throws IOException, SQLException {
		
		//TextField usernamefield = new TextField();
		//TextField passwordfield = new TextField();
		
		//System.out.println(passwordfield.getText());
		
		Database db = new Database();
        boolean flag = db.validate(usernamefield.getText(), passwordfield.getText());
        
       if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
        	AnchorPane MainPage;
    		Stage primaryStage = new Stage();
    		MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("MainPage.fxml"));
    		Scene MainPageScene = new Scene(MainPage,1100,800);
    		MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		primaryStage.setScene(MainPageScene);
    		primaryStage.setResizable(false);
    		primaryStage.show();
        }	
		
       
	}
	
	
	public static void infoBox(String infoMessage, String headerText, String title) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
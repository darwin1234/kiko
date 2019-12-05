package assignmentgui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import MongoDBConnection.Crud;
import MongoDBConnection.Row;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import kikoassigment.Events;

public class Controller implements Initializable {
	
	public Text title_row1,content_1,price_1,location_1,date_1;
	public Text title_row2,content_2,price_2,location_2,date_2;
	public Text title_row3,content_3,price_3,location_3,date_3;
	public Text title_row4,content_4,price_4,location_4,date_4;
	public ImageView photo1,photo2,photo3,photo4;
	public Button view_1,view_2,view_3,view_4;
	public TextField loadmain;
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public void mainpage() {
		System.out.print("asdadasdsad");
	}
	
	public void initialize(URL url, ResourceBundle rb) 
	{
		
		Crud db = new Crud();
		Integer value1 = Integer.valueOf(loadmain.getText());
		
		if(value1.equals(22)) {
			ArrayList<Row> ticket = db.display();	
				int i = 0;
				for (Row printRow : ticket)
		        {
					
					i++;
					
				   if(i == 1)
				   {	
					    Image img1 = new Image("file:images/1.png",true);
					    photo1.setImage(img1);
						title_row1.setText(printRow.getTitle());
						content_1.setText(printRow.getDescription().substring(0, 350));
						price_1.setText("PRICE: " + printRow.getPrice() + " USD");
						location_1.setText("LOCATION: " + printRow.getLocation());
						view_1.addEventHandler(MouseEvent.MOUSE_CLICKED, new Events(printRow.getID()));
						
				   }else if(i == 2) 
				   {
					    Image img1 = new Image("file:images/2.png",true);
					    photo2.setImage(img1);
						title_row2.setText(printRow.getTitle());
						content_2.setText(printRow.getDescription().substring(0, 350));
						price_2.setText("PRICE: " + printRow.getPrice() + " USD");
						location_2.setText("LOCATION: " + printRow.getLocation());
						view_2.addEventHandler(MouseEvent.MOUSE_CLICKED, new Events(printRow.getID()));
				   }else if(i == 3)
				   {
					    Image img1 = new Image("file:images/3.png",true);
					    photo3.setImage(img1);
						title_row3.setText(printRow.getTitle());
						content_3.setText(printRow.getDescription().substring(0, 350));
						price_3.setText("PRICE: " + printRow.getPrice() + " USD");
						location_3.setText("LOCATION: " + printRow.getLocation());
						view_3.addEventHandler(MouseEvent.MOUSE_CLICKED, new Events(printRow.getID()));
				   }else if(i == 4) 
				   {
					    Image img1 = new Image("file:images/4.png",true);
					    photo4.setImage(img1);
						title_row4.setText(printRow.getTitle());
						content_4.setText(printRow.getDescription().substring(0, 350));
						price_4.setText("PRICE: " + printRow.getPrice() + " USD");
						location_4.setText("LOCATION: " + printRow.getLocation());
						view_4.addEventHandler(MouseEvent.MOUSE_CLICKED, new Events(printRow.getID()));
				   }else 
				   {
					   i = 0;
				   }
		        }
				
		}
	
	}
	
	@FXML
	public void ProceedLogin(ActionEvent event) throws IOException  {
		
		//TextField usernamefield = new TextField();
		//TextField passwordfield = new TextField();
		
		//System.out.println(passwordfield.getText());
		
		//Database db = new Database();
       // boolean flag = db.validate(usernamefield.getText(), passwordfield.getText());
        
		LoadGui ldGui = new LoadGui();
       
       ldGui.loadTemplateFXML("Main.fxml");
	}
	
	public void ViewSingle(){
		
	}
	
	public void createTicket() throws IOException {
		LoadGui ldGui = new LoadGui();
		ldGui.loadTemplateFXML("CreateTicket.fxml");
	}
	
	public void addTrack() {
		Stage primaryStage = new Stage();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		File file = fileChooser.showOpenDialog(primaryStage);
		if (file != null) {
            //openFile(file);
			//System.out.print(file.toURI().toString());
			
			File destination = new File("..\\..\\..\\..\\photos", file.getName());
			boolean success = file.renameTo(destination);
			System.out.println(success);
		}
	}
	
	public void Signup() throws IOException {
		
		LoadGui ldGui = new LoadGui();
		ldGui.loadTemplateFXML("Signup.fxml");
	}
	
	
}

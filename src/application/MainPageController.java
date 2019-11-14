package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPageController implements Initializable {
	 
	
	
	   
	//@FXML
	//private ComboBox genre; 
	
	public Text title_row1,content_1,price_1,location_1,date_1;
	public Text title_row2,content_2,price_2,location_2,date_2;
	public Text title_row3,content_3,price_3,location_3,date_3;
	public Text title_row4,content_4,price_4,location_4,date_4;
	public ImageView photo1,photo2,photo3,photo4;
	public Button view_1,view_2,view_3,view_4;
	
	
	public MainPageController() {

		
	}
	
	public void initialize(URL url, ResourceBundle rb) {
		
		Database db = new Database();
		ArrayList<Row> ticket = db.ticket();

		//Row print;
		//print.getFirstName();
		int i = 0;
		for (Row printRow : ticket)
        {
			
			i++;
			
		   if(i == 1)
		   {	
			    Image img1 = new Image("file:images/1.png",true);
			    photo1.setImage(img1);
				title_row1.setText(printRow.getTitle());
				content_1.setText(printRow.getDescription());
				price_1.setText("PRICE: " + printRow.getPrice() + " USD");
				location_1.setText("LOCATION: " + printRow.getLocation());
				view_1.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler(printRow.getID()));
				
		   }else if(i == 2) 
		   {
			    Image img1 = new Image("file:images/2.png",true);
			    photo2.setImage(img1);
				title_row2.setText(printRow.getTitle());
				content_2.setText(printRow.getDescription());
				price_2.setText("PRICE: " + printRow.getPrice() + " USD");
				location_2.setText("LOCATION: " + printRow.getLocation());
				view_2.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler(printRow.getID()));
		   }else if(i == 3)
		   {
			    Image img1 = new Image("file:images/3.png",true);
			    photo3.setImage(img1);
				title_row3.setText(printRow.getTitle());
				content_3.setText(printRow.getDescription());
				price_3.setText("PRICE: " + printRow.getPrice() + " USD");
				location_3.setText("LOCATION: " + printRow.getLocation());
				view_3.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler(printRow.getID()));
		   }else if(i == 4) 
		   {
			    Image img1 = new Image("file:images/4.png",true);
			    photo4.setImage(img1);
				title_row4.setText(printRow.getTitle());
				content_4.setText(printRow.getDescription());
				price_4.setText("PRICE: " + printRow.getPrice() + " USD");
				location_4.setText("LOCATION: " + printRow.getLocation());
				view_4.addEventHandler(MouseEvent.MOUSE_CLICKED, new MyEventHandler(printRow.getID()));
		   }else 
		   {
			   i = 0;
		   }
        }
		
		

	}
	
	

	@FXML
	public void ViewSingle(ActionEvent event) throws IOException {
		
		/*AnchorPane MainPage;
		Stage primaryStage = new Stage();
		MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("SinglePage.fxml"));
		Scene MainPageScene = new Scene(MainPage); 
		MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(MainPageScene);
		primaryStage.setResizable(false);
		primaryStage.show();*/
		//System.out.println("HELLO");
		
	}
	
	
	 private class MyEventHandler implements EventHandler<Event>{
		 
		private final int id; 
		MyEventHandler(int id){
			this.id =id;
		}

		@Override
		public void handle(Event arg0) {
			// TODO Auto-generated method stub
			System.out.println("ID: " + this.id);
			AnchorPane MainPage;
			Stage primaryStage = new Stage();
			try {
				MainPage = (AnchorPane)FXMLLoader.load(getClass().getResource("SinglePage.fxml"));
				Scene MainPageScene = new Scene(MainPage); 
				MainPageScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(MainPageScene);
				primaryStage.setResizable(false);
				primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		public int getID() {
			 return id;
		 }
	   }
	 
	 
}

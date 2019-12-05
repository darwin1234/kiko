package kikoassigment;

import java.io.IOException;

import assignmentgui.LoadGui;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Events implements EventHandler<Event>{
	 
	private final String id; 
	public Events(String string){
		this.id = string;
	}

	
	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		LoadGui ldGui = new LoadGui();
	    try {
			ldGui.loadTemplateFXML("SinglePage.fxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getID() {
		 return id;
	}
  

}

package chatlocal.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {
	
	private VBox view;
	
	public MainController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainView.fxml"));
		loader.setController(this);
		try {
			view = loader.load();
		} catch (IOException e) {
			System.err.println("ERROR al cargar la vista: "+e.getMessage());
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resource) {
		

	}
	
	public VBox getView() {
		return view;
	}
}

package chatlocal.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;

import chatlocal.customs.CustomConversation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

	@FXML
	private SplitPane splitPane;

	@FXML
	private Button menuButton;

	@FXML
	private ImageView menuImageView;

	@FXML
	private Button mensajeButton, directorioContactosButton, agregarContactoButton, ajustesButton;

	@FXML
	private VBox mainListaLeftVBox;

	@FXML
	private TextField buscarConverTextField;

	@FXML
	private VBox listaConverVBox;

	@FXML
	private BorderPane mensajesRightBorderPane;

	@FXML
	private TextField mensajeTextField;

	@FXML
	private Button adjuntoButton, enviarButton;

	@FXML
	private VBox mensajePersonasVBox;
	/*
	 * 
	 * */
	private VBox view;
	private Boolean expandido = true; // Controlar el menu expandido
	private FlowPane directoryContactosFP;
	private VBox auxiliar; 

	public MainController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainView.fxml"));
		loader.setController(this);
		try {
			view = loader.load();
		} catch (IOException e) {
			System.err.println("ERROR al cargar la vista: " + e.getMessage());
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resource) {
		auxiliar = new VBox();
		auxiliar.getChildren().addAll(mainListaLeftVBox.getChildren());
		directoryContactosFP = new FlowPane();
		
		menuButton.setOnAction(e -> {
			if (expandido) {
				menuImageView.setImage(new Image("file:image/icon/menu_close.png"));
				splitPane.setDividerPositions(0.0);
				expandido = false;
			} else {
				menuImageView.setImage(new Image("file:image/icon/menu_open.png"));
				splitPane.setDividerPositions(0.5);
				expandido = true;
			}
		});
		mensajeButton.setOnAction(e -> {
			
			mainListaLeftVBox.getChildren().setAll(auxiliar);
			
		});
		
		directorioContactosButton.setOnAction(e -> {
			
			mainListaLeftVBox.getChildren().setAll(directoryContactosFP);
		});
		
		/*
		 * Test
		 * */
		CustomConversation addConver;
		ImageView imagen;
		Date hora;
		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		for (int i = 0; i < 6; i++) {
			addConver = new CustomConversation();
			hora  = new Date();
			
			imagen = new ImageView("file:image/aleatorio/img0.jpg");
			
			addConver.getNombreModel().set("Nombre "+i);
			addConver.getHoraModel().set(hourFormat.format(hora));
			addConver.getMensajeModel().set("Aqui va el mensaje");
			addConver.setImagePerfil(imagen);
			
			listaConverVBox.getChildren().add(addConver.getConversation());
			
		}
			
		
	}

	public VBox getView() {
		return view;
	}
}

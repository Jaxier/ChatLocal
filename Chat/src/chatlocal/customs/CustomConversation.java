package chatlocal.customs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CustomConversation extends HBox {

	private HBox conversation;
	private HBox headerHBox;
	private VBox textosVBox;

	private CustomImageCircle imagePerfil;
	private Label nombre, ultimoMensaje, horaUltimoMensaje;

	private StringProperty nombreModel, mensajeModel, horaModel;
	private final Integer MAXCHAR = 10; // Tamaño maximo de caracteres

	public CustomConversation() {

		conversation = new HBox();
		headerHBox = new HBox();
		textosVBox = new VBox();
		imagePerfil = new CustomImageCircle();

		nombre = new Label();
		ultimoMensaje = new Label();
		horaUltimoMensaje = new Label();

		headerHBox.getChildren().addAll(nombre, horaUltimoMensaje);
		HBox.setHgrow(nombre, Priority.ALWAYS);
		nombre.setAlignment(Pos.BASELINE_LEFT);
		horaUltimoMensaje.setAlignment(Pos.BASELINE_RIGHT);

		textosVBox.getChildren().addAll(headerHBox, ultimoMensaje);

		conversation.getChildren().addAll(imagePerfil, textosVBox);

		/*
		 * Preparando bindeos
		 */
		nombreModel = new SimpleStringProperty(this, "nombreModel", "Desconocido");
		mensajeModel = new SimpleStringProperty(this, "mensajeModel", "");
		horaModel = new SimpleStringProperty(this, "nombreModel", "??:??");

		/*
		 * Bindeos
		 */
		nombre.textProperty().bind(nombreModel);
		ultimoMensaje.textProperty().bind(mensajeModel);
		horaUltimoMensaje.textProperty().bind(horaModel);

		/*
		 * Lissener textos grandes
		 */
		nombreModel.addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (nombreModel.get().length() > MAXCHAR) {
					nombreModel.set(nombreModel.get().substring(0, MAXCHAR));
				}
			}
		});

		mensajeModel.addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (mensajeModel.get().length() > MAXCHAR) {
					mensajeModel.set(mensajeModel.get().substring(0, MAXCHAR));
				}
			}
		});

	}

	public CustomImageCircle getImagePerfil() {
		return imagePerfil;
	}

	public void setImagePerfil(ImageView image) {
		this.imagePerfil.setImageView(image);
	}

	public StringProperty getNombreModel() {
		return nombreModel;
	}

	public void setNombreModel(StringProperty nombreModel) {
		this.nombreModel = nombreModel;
	}

	public StringProperty getMensajeModel() {
		return mensajeModel;
	}

	public void setMensajeModel(StringProperty mensajeModel) {
		this.mensajeModel = mensajeModel;
	}

	public StringProperty getHoraModel() {
		return horaModel;
	}

	public void setHoraModel(StringProperty horaModel) {
		this.horaModel = horaModel;
	}
	
	

}

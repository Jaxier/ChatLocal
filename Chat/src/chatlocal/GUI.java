package chatlocal;

import chatlocal.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MainController controller = new MainController();
		
		primaryStage.setTitle("ChatLocal");
		primaryStage.setScene(new Scene(controller.getView()));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}

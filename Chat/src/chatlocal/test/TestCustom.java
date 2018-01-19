package chatlocal.test;

import chatlocal.customs.CustomImageCircle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TestCustom extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
//		CustomImageCircle myImg = new CustomImageCircle();
//		ImageView img = new ImageView("file:image/defaults/people.png");
//		Circle clip = new Circle(100, 200, 20);
//		clip.setFill(Paint.valueOf("RED"));
//		img.setClip(clip);
//		
//		myImg.setImageView(img);
//		
//		
	
//        ImageView imageView = new ImageView("file:image/defaults/people.png");
//      
//        Circle clip = new Circle(100);
//        
//        imageView.setFitHeight(50);
//        imageView.setFitWidth(50);
//        
//        clip.centerXProperty().bind(imageView.fitHeightProperty().divide(2));
//        clip.centerYProperty().bind(imageView.fitWidthProperty().divide(2));
//        
//        clip.radiusProperty().bind(
//        		(imageView.fitHeightProperty().divide(2))
//        		.add(imageView.getFitWidth()/2).divide(2)
//        		);
//        
//        System.out.println(imageView.getFitHeight()/2+" "+imageView.getFitWidth()/2);
//        System.out.println(Math.sqrt(imageView.getFitHeight()+imageView.getFitWidth()));
//        
//        imageView.setPreserveRatio(true);
//        clip.setFill(Color.BLACK);
//               
//        imageView.setClip(clip);
        CustomImageCircle img = new CustomImageCircle();
        
//        Image imag = new Image("file:image/defaults/people.png");
        
        img.setImageView(new ImageView("file:image/defaults/people.png"));
        
        VBox vbox = new VBox(img.getImageView());
//        vbox.setStyle("-fx-background-color: red");
//        vbox.getChildren().add(clip);
        
		primaryStage.setScene(new Scene(vbox));
		primaryStage.show();
	}
		
	public static void main(String[] args) {
		launch(args);
	}

	

}

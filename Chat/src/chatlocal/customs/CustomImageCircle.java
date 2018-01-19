package chatlocal.customs;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class CustomImageCircle extends ImageView {

	private Circle clip = new Circle();
	private ImageView imageView;
	
		
	public CustomImageCircle() {
		super();
				
		imageView = new ImageView("file:image/defaults/people.png");
		
		imageView.setFitHeight(50);
		imageView.setFitWidth(50);
		
		clip.centerXProperty().bind(imageView.fitHeightProperty().divide(2));
		clip.centerYProperty().bind(imageView.fitWidthProperty().divide(2));
		
		clip.radiusProperty().bind(
        		(imageView.fitHeightProperty().divide(2))
        		.add(imageView.getFitWidth()/2).divide(2)
        		);
		
		imageView.setClip(clip);
		
		
	}
	
	public void setUrlImage(String urlImage) {
		setImageView(new ImageView(urlImage));
	}
	
	public void setImageView(ImageView image) {
		this.imageView.setClip(null);
		this.imageView = image;
		this.imageView.setFitHeight(50);
		this.imageView.setFitWidth(50);
		this.imageView.setClip(clip);		
		
	}

	public ImageView getImageView() {
		return imageView;
	}

}

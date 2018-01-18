package chatlocal.customs;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class CustomImageCircle extends ImageView {

	private Circle clip;
	private ImageView imageView;

	public CustomImageCircle() {
		super();
		clip = new Circle(300, 200, 200);
		imageView = new ImageView();

		clip.radiusProperty().bind((this.fitHeightProperty().multiply(this.fitWidthProperty()).divide(2)));
		imageView.setClip(clip);

	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

	public ImageView getImageView() {
		return imageView;
	}

}

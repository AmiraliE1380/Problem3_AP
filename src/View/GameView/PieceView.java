package View.GameView;

import Model.Pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PieceView extends StackPane {
    private Piece piece;
    //TODO: SET THE PHOTO OF THE PIECE
    private int xGridPain;
    private int yGridPain;
    private ImageView imageView;

    public PieceView(Piece piece) {
        this.piece = piece;
        loadImage();
        //the coordination of the piece class is different with the gridPane:
        yGridPain = piece.getY();
        xGridPain = 8 - piece.getX();
    }

    private void loadImage() {
        String address = "resources\\pieces\\" + piece.getColor().toString() + "_" + piece.getType().toString() + ".png";
        Image image = new Image(address, 50, 50, true, true);
        imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }
}

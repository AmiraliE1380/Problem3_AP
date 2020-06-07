package View.GameView;

import Model.Pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class PieceView extends StackPane {
    private Piece piece;
    //TODO: SET THE PHOTO OF THE PIECE
    private int xGridPain;
    private int yGridPain;
    private GridPane chessboard;
    private double mouseX;
    private double mouseY;
    private double oldX;
    private double oldY;
    private ImageView imageView;

    public PieceView(Piece piece, GridPane chessboard) {
        this.piece = piece;
        this.chessboard = chessboard;
        loadImage();
        //the coordination of the piece class is different with the gridPane:
        yGridPain = piece.getY();
        xGridPain = 8 - piece.getX();
        move(xGridPain, yGridPain);

        setOnMousePressed(e -> {
            mouseX = e.getSceneX();
            mouseY = e.getSceneY();
            System.out.println(mouseX);
            System.out.println(mouseY);
        });

        setOnMouseDragged(e -> {
            chessboard.getChildren().remove(this);
            System.out.println(e.getSceneX() + "   " + e.getSceneY());
            relocate(e.getSceneX(), e.getSceneY());
        });
    }

    private void loadImage() {
        String address = "resources\\pieces\\" + piece.getColor().toString() + "_" + piece.getType().toString() + ".png";
        Image image = new Image(address, 50, 50, true, true);
        imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    public void move(int x, int y) {
        oldX = chessboard.getLayoutX() + 50 * x;
        oldY = chessboard.getLayoutY() + 50 * y;
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }
}

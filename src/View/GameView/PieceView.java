package View.GameView;

import Controller.Game;
import Model.Pieces.Piece;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class PieceView extends StackPane {
    private Piece piece;
    //TODO: SET THE PHOTO OF THE PIECE
    private int xGridPain;
    private int yGridPain;

    public PieceView(Piece piece) {
        this.piece = piece;

        //the coordination of the piece class is different with the gridPane:
        yGridPain = piece.getY();
        xGridPain = 8 - piece.getX();
    }

}

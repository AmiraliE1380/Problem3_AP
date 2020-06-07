package View.GameView;

import Controller.Game;
import Model.Pieces.Piece;
import View.AccountView.MainView.MainMenu;
import View.MenuManager;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameManager extends MenuManager implements Initializable {
    public Label showPlayers;
    public Label assertionLabel;
    public GridPane chessBoard;
    public Group pieces = new Group();
    private Game game = Game.getInstance();
    {
        parentMenu = new MainMenu();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showPlayers.setText(game.getPlayer1() + " vs " + game.getPlayer2());
        setBoardsNumbersAndLetters();
        constructTilesAndPieces();
        chessBoard.getChildren().addAll(pieces);
    }

    private void constructTilesAndPieces() {
        for(int i = 0; i < 8; i++) {
            for(int j = 1; j < 9; j++) {
                Tile tile = new Tile((i + j) % 2 == 0);
                Piece piece = game.getPiece(8 - i, j);
                chessBoard.add(tile, j, i);
                if(piece != null) {
                    PieceView pieceView = new PieceView(piece);
                    pieces.getChildren().add(pieceView);
                    tile.setPieceView(pieceView);
                    chessBoard.add(pieceView, j, i);
                }
            }
        }
    }

    private void setBoardsNumbersAndLetters() {
        for(int i = 0; i < 8; i++) {
            Label label = new Label(Integer.toString(8 - i));
            label.getStyleClass().add("myLabelStyle");
            label.setAlignment(Pos.CENTER);
            label.setPrefWidth(50);
            chessBoard.add(label,0, i);
            label = new Label(Character.toString((char)('A' + i)));
            label.getStyleClass().add("myLabelStyle");
            label.setPrefWidth(50);
            label.setAlignment(Pos.CENTER);
            chessBoard.add(label, i + 1,8);
        }
    }

    public void forfeit() {
        game.forfeit();
        try {
            parentMenu.start(stage);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void move() {

    }

    public void undo() {
    }

    //TODO: WRITE METHODS TO TURN COORDINATES FROM GRID PANE FORMAT TO CONTROLLER AND VICE VERSA
}

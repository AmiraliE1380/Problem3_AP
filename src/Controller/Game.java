package Controller;

import Model.Player;
import Model.Pieces.*;

import java.util.ArrayList;

public class Game {
    private static Game game = new Game();
    private Player player1;
    private Player player2;
    private int turns;
    private ArrayList<Piece> pieces;
    private Piece.Color movingPlayer;
    private Memory memory;
    private Piece selectedPiece;

    private Game(){}

    public static Game getInstance() {
        return game;
    }

    public void startGame(Player player1, Player player2, int turns) {
        this.player1 = player1;
        this.player2 = player2;
        this.turns = getLimit(turns);
        movingPlayer = Piece.Color.WHITE;
        initializePieces();
        memory = new Memory();
    }

    private int getLimit(int turns) {
        if(turns == 0) {
            return -1;
        } else {
            return turns;
        }
    }

    private void initializePieces() {
        pieces = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            pieces.add(new Pawn(Piece.Color.WHITE, 2, i + 1));
            pieces.add(new Pawn(Piece.Color.BLACK, 7, i + 1));
        }

        pieces.add(new Queen(Piece.Color.WHITE, 1, 4));
        pieces.add(new Queen(Piece.Color.BLACK, 8, 4));

        pieces.add(new King(Piece.Color.WHITE, 1, 5));
        pieces.add(new King(Piece.Color.BLACK, 8, 5));

        pieces.add(new Rook(Piece.Color.WHITE, 1, 1));
        pieces.add(new Rook(Piece.Color.WHITE, 1, 8));
        pieces.add(new Rook(Piece.Color.BLACK, 8, 1));
        pieces.add(new Rook(Piece.Color.BLACK, 8, 8));

        pieces.add(new Bishop(Piece.Color.WHITE, 1, 3));
        pieces.add(new Bishop(Piece.Color.WHITE, 1, 6));
        pieces.add(new Bishop(Piece.Color.BLACK, 8, 3));
        pieces.add(new Bishop(Piece.Color.BLACK, 8, 6));

        pieces.add(new Knight(Piece.Color.WHITE, 1, 2));
        pieces.add(new Knight(Piece.Color.WHITE, 1, 7));
        pieces.add(new Knight(Piece.Color.BLACK, 8, 2));
        pieces.add(new Knight(Piece.Color.BLACK, 8, 7));
    }

    public void endGame() {
        player1 = null;
        player2 = null;
        turns = 0;
        pieces = null;
        memory = null;
    }

    public void select(int x, int y) throws Exception {
        if(Piece.isInCoordinationAnAlivePiece(x, y))
            throw new Exception("There is no piece in the coordination.");
        if(!Piece.getAlivePiece(x, y).getColor().equals(movingPlayer))
            throw new Exception("You must choose one of your one pieces.");

    }
}

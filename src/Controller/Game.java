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
    private Piece selectedPiece;
    private Piece killedPiece;
    private boolean hasMoved;

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
        hasMoved = false;
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
    }

    public void select(int x, int y) throws Exception {
        if(Piece.isInCoordinationAnAlivePiece(x, y))
            throw new Exception("There is no piece in the coordination.");
        if(!Piece.getAlivePiece(x, y).getColor().equals(movingPlayer))
            throw new Exception("You must choose one of your one pieces.");
        selectedPiece = Piece.getAlivePiece(x, y);
    }

    public void deselect() {
        selectedPiece = null;
    }

    public void move(int x, int y) throws Exception {
        if(!selectedPiece.canPieceMakeSuchMove(x, y) || selectedPiece.isObstacleInWay(x, y))
            throw new Exception("Piece can not make such move!");
        if(Piece.isInCoordinationAnAlivePiece(x, y)) {
            Piece piece = Piece.getAlivePiece(x, y);
            if (piece.getColor().equals(movingPlayer))
                throw new Exception("You can't kill one of your own pieces!");
            piece.setDead(true);
            killedPiece = piece;
        } else {
            killedPiece = null;
        }
        selectedPiece.setX(x);
        selectedPiece.setY(y);
        hasMoved = true;
    }

    public void nextTurn() throws Exception {
        if(!hasMoved)
            throw new Exception("You must make a move every turn.");
        if(movingPlayer.equals(Piece.Color.BLACK))
            movingPlayer = Piece.Color.WHITE;
        else
            movingPlayer = Piece.Color.BLACK;
        killedPiece.setDead(true);
        resetAlivePieces(killedPiece);
        killedPiece = null;
        selectedPiece = null;
        selectedPiece = null;
        turns--;
        hasMoved = false;
    }

    private void resetAlivePieces(Piece killedPiece) {
        Piece.getAlivePieces().remove(killedPiece);
    }

    public void forfeit() {
        if(movingPlayer.equals(Piece.Color.BLACK)) {
            player2.setNumOfOwnForfeits(player2.getNumOfOwnForfeits() + 1);
            player1.setNumOfRivalForfeits(player1.getNumOfRivalForfeits() + 1);
        } else {
            player1.setNumOfOwnForfeits(player1.getNumOfOwnForfeits() + 1);
            player2.setNumOfRivalForfeits(player2.getNumOfRivalForfeits() + 1);
        }
        endGame();
    }

    public boolean hasGameEnded() {
        for(Piece piece: pieces) {
            if(piece.getType().equals(Piece.Type.KNIGHT)){
                if(piece.isDead()) {
                    setResult(piece.getColor());
                    return true;
                }
            }
        }
        if(turns == 0) {
            player1.setNumOfDraws(1 + player1.getNumOfDraws());
            player2.setNumOfDraws(1 + player2.getNumOfDraws());
            return true;
        }
        return false;
    }

    private void setResult(Piece.Color looserColor) {
        if(looserColor.equals(Piece.Color.BLACK)) {
            player1.setNumOfWins(player1.getNumOfWins() + 1);
            player2.setNumOfLooses(player2.getNumOfLooses() + 1);
        } else {
            player2.setNumOfWins(player2.getNumOfWins() + 1);
            player1.setNumOfLooses(player1.getNumOfLooses() + 1);
        }
    }


}

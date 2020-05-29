package Controller;

import Model.Pieces.Piece;
import Model.Player;

import java.util.ArrayList;

public class Undo {
    private Player player1;
    private Player player2;
    private int xOrigin;
    private int yOrigin;
    private int player1TotalUndoChoices;
    private int player2TotalUndoChoices;
    private boolean player1CanUndoThisTurn;
    private boolean player2CanUndoThisTurn;

    public Undo(Player player1, Player player2, int totalUndo) {
        this.player1 = player1;
        this.player2 = player2;
        player1CanUndoThisTurn = true;
        player2CanUndoThisTurn = true;
        this.player1TotalUndoChoices = totalUndo;
        this.player2TotalUndoChoices = totalUndo;
    }

    public void makeMove() {
        player2CanUndoThisTurn = true;
        player1CanUndoThisTurn = true;
        this.xOrigin = 0;
        this.yOrigin = 0;
    }

    public void temporaryMove(int xOrigin, int yOrigin) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
    }

    public boolean canUndo(Piece.Color color) {
        if(color.equals(Piece.Color.BLACK)) {
            if(!player2CanUndoThisTurn)
                return false;
            if(player2TotalUndoChoices < 1)
                return false;
        } else {
            if(!player1CanUndoThisTurn)
                return false;
            if(player1TotalUndoChoices < 1)
                return false;
        }
        return true;
    }

    public void execute(Piece.Color color) {
        if (color.equals(Piece.Color.BLACK)) {
            player2TotalUndoChoices--;
            player2CanUndoThisTurn = false;
        } else {
            player1TotalUndoChoices--;
            player1CanUndoThisTurn = false;
        }
    }

    public int getXOrigin() {
        return xOrigin;
    }

    public int getYOrigin() {
        return yOrigin;
    }
}

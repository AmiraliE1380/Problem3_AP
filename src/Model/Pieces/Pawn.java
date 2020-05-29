package Model.Pieces;

import java.util.ArrayList;

public class Pawn extends Piece {
    public Pawn(Color color, int x, int y) {
        super(color, Type.PAWN, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        if(isInCoordinationAnAlivePiece(x, y)) {
            if(y == this.y) {
                return true;
            }
        }
        if(this.color.equals(Color.WHITE)) {//for the situation it wants to jump two steps
            if(x == this.x + 2 && isInCoordinationAnAlivePiece(x - 1, y)) {
                return true;
            }
        }
        if(this.color.equals(Color.BLACK)) {
            if(x == this.x - 2 && isInCoordinationAnAlivePiece(x + 1, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(canJumpTwoSteps(x, y)){
            return true;
        }
        if(y == this.y + 1 || y == this.y - 1 ) {
            if(color.equals(Color.WHITE)) {
                if(x == this.x + 1) {
                    return canKillRival(x, y);
                }
            }
            if(color.equals(Color.BLACK)) {
                if(x == this.x - 1) {
                    return canKillRival(x, y);
                }
            }
        }
        return false;
    }

    private boolean canJumpTwoSteps(int x, int y) {
        if(y == this.y) {
            if(color.equals(Color.WHITE)) {
                if(this.x == 2 && x == 4)
                    return true;
                if(this.x + 1 == x)
                    return true;
            }
            if(color.equals(Color.BLACK)) {
                if(this.x == 7 && x == 5)
                    return true;
                if(this.x - 1 == x)
                    return true;
            }
        }
        return false;
    }

    private boolean canKillRival(int x, int y) {
        if(isInCoordinationAnAlivePiece(x, y)) {
            // this was erased: && getAlivePieceByCoordination(xCoordinate, yCoordinate, allPieces) != null
            if(!getAlivePiece(x, y).getColor().equals(this.color))
                return true;
        }
        return false;
    }
}

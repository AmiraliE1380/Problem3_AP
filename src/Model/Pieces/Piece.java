package Model.Pieces;

import java.util.ArrayList;

public abstract class Piece {
    protected static ArrayList<Piece> alivePieces;
    protected Color color;
    protected Type type;
    protected int x;
    protected int y;
    protected boolean isDead;

    public enum Type {BISHOP, KING, KNIGHT, QUEEN, PAWN, ROOK}
    public enum Color{WHITE, BLACK}

    public Piece(Color color, Type type, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.type = type;
        this.isDead = false;
    }

    public static void setAlivePieces(ArrayList<Piece> alivePieces) {
        Piece.alivePieces = alivePieces;
    }

    public static boolean isInCoordinationAnAlivePiece(int x, int y) {
        for(Piece piece: alivePieces) {
            if(piece.getX() == x && piece.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public static Piece getAlivePiece(int x, int y) {
        for(Piece piece: alivePieces) {
            if(piece.getX() == x && piece.getY() == y) {
                return piece;
            }
        }
        return null;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public abstract boolean isObstacleInWay(int x, int y);

    public abstract boolean canPieceMakeSuchMove(int x, int y);
}

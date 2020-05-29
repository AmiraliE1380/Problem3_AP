package Model.Pieces;

public abstract class Piece {
    protected String color;
    protected Type type;
    protected int x;
    protected int y;
    protected boolean isDead;

    public Piece(String color, Type type, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.type = type;
        this.isDead = false;
    }
}

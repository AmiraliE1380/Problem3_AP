package Model.Pieces;

public class Knight extends Piece {
    public Knight(Color color, int x, int y) {
        super(color, Type.KNIGHT, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        return false;
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(x == this.x + 2 || x == this.x - 2) {
            if(y == this.y + 1 || y == this.y - 1)
                return true;
        }
        if(y == this.y + 2 || y == this.y - 2) {
            if(x == this.x + 1 || x == this.x - 1)
                return true;
        }
        return false;
    }
}

package Model.Pieces;

public class King extends Piece {
    public King(Color color, int x, int y) {
        super(color, Type.KING, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        return false;
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(y == this.y + 1 || y == this.y - 1) {
            if (x == this.x)
                return true;
            if (x == this.x + 1 || x == this.x - 1)
                return true;
        }
        if(y == this.y) {
            if(x == this.x + 1 || x == this.x - 1)
                return true;
        }
        return false;
    }
}

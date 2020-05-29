package Model.Pieces;

public class Rook extends Piece {
    public Rook(Color color, int x, int y) {
        super(color, Type.ROOK, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        if(x == this.x && y > this.y)
            return isObstacleInDirectPath(this.y, y, x, true);
        if(x == this.y && y < this.y)
            return isObstacleInDirectPath(this.y, y, x, true);
        if(x > this.x && y == this.y)
            return isObstacleInDirectPath(this.x, x, y, false);
        if(x < this.x && y == this.y)
            return isObstacleInDirectPath(x, this.x, y, false);

        return false;
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(x == this.x)
            return true;
        if(y == this.y)
            return true;
        return false;
    }

    private boolean isObstacleInDirectPath(int origin, int destination, int constCoordinate, boolean isXAxis) {
        for(int i = origin + 1; i < destination; i++) {
            if(isXAxis) {
                if(isInCoordinationAnAlivePiece(constCoordinate, i))
                    return true;
            }else {
                if(isInCoordinationAnAlivePiece(i, constCoordinate))
                    return true;
            }
        }

        return false;
    }
}
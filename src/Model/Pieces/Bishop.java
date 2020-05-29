package Model.Pieces;

public class Bishop extends Piece {
    public Bishop(Color color, Type type, int x, int y) {
        super(color, type, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        if(x > this.x && y > this.y)
            return isObstacleInUndirectLine(this.x, this.y, x);
        if(x > this.x && y < this.y)
            return isObstacleInUndirectLineMainDiameterOfMatrix(this.x,  this.y, x);
        if(x < this.x && y > this.y)
            return isObstacleInUndirectLineMainDiameterOfMatrix(x, y, this.x);
        if(x < this.x && y < this.y)
            return isObstacleInUndirectLine(x, y, this.x);
        return false;
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(x - y == this.x - this.y)
            return true;
        if(x + y == this.x + this.y)
            return true;
        return false;
    }

    private boolean isObstacleInUndirectLine(int xOrigin, int yOrigin, int xDestination) {
        for(int i = xOrigin + 1, j = yOrigin + 1; i < xDestination; i++, j++) {
            if(isInCoordinationAnAlivePiece(i, j)) {
                return true;
            }
        }
        return false;
    }

    private boolean isObstacleInUndirectLineMainDiameterOfMatrix(int xOrigin, int yOrigin, int xDestination) {
        //searches the main diameter in the matrix
        for(int i = xOrigin + 1, j = yOrigin - 1; i < xDestination; i++, j--) {
            if(isInCoordinationAnAlivePiece(i, j)) {
                return true;
            }
        }
        return false;
    }

}

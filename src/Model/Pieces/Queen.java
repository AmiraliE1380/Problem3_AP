package Model.Pieces;

public class Queen extends Piece {
    public Queen(Color color, int x, int y) {
        super(color, Type.QUEEN, x, y);
    }

    @Override
    public boolean isObstacleInWay(int x, int y) {
        if(x != this.x && y != this.y)
            return new Bishop(color, this.x, this.y).isObstacleInWay(x, y);

        return new Rook(color, this.x, this.y).isObstacleInWay(x, y);
    }

    @Override
    public boolean canPieceMakeSuchMove(int x, int y) {
        if(new Rook(color, this.x, this.y).canPieceMakeSuchMove(x, y))
            return true;

        if(new Bishop(color, this.x, this.y).canPieceMakeSuchMove(x, y))
            return true;

        return false;
    }
}

package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Bishop extends ChessPiece{

    public Bishop(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean move(Chessboard chessboard, Coordinates destination) {
        if (canMove(chessboard, destination) && !canThreatenKing(chessboard, destination)) {
            location = destination;
            hasMoved = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        int xDiff = Math.abs(getLocation().getX() - destination.getX());
        int yDiff = Math.abs(getLocation().getY() - destination.getY());
        int xDirection = Integer.compare(0, getLocation().getX() - destination.getX());
        int yDirection = Integer.compare(0, getLocation().getY() - destination.getY());
        for (int i = 1; i < xDiff; i++) {
            if ( chessboard.getPiece(
                    new Coordinates(getLocation().getX() + i * xDirection, getLocation().getY() + i * yDirection)
            ) != null) return false;
        }
        return xDiff == yDiff && (chessboard.getPiece(destination) == null || chessboard.getPiece(destination).getPlayer() != getPlayer());
    }
}

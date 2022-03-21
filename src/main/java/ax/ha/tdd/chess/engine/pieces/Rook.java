package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Rook extends ChessPiece{

    public Rook(PieceType pieceType, Player player, Coordinates location) {
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
        int xDirection = Integer.compare(0, getLocation().getX() - destination.getX());
        int yDirection = Integer.compare(0, getLocation().getY() - destination.getY());
        int steps = 0;
        if (xDirection != 0) steps = Math.abs(getLocation().getX() - destination.getX());
        else if (yDirection != 0) steps = Math.abs(getLocation().getY() - destination.getY());
        boolean straightLine = getLocation().getX() == destination.getX() || getLocation().getY() == destination.getY();
        for (int i = 1; i < steps; i++) {
            if ( xDirection != 0 && chessboard.getPiece(
                        new Coordinates(getLocation().getX() + i * xDirection, getLocation().getY())
            ) != null) return false;
            if ( yDirection != 0 && chessboard.getPiece(
                    new Coordinates(getLocation().getX(), getLocation().getY() + i * yDirection)
            ) != null) return false;
        }
        //boolean kingIsPresent = chessboard.getPiece(destination) != null && chessboard.getPiece(destination).pieceType.equals(PieceType.KING);
        return straightLine && (chessboard.getPiece(destination) == null || chessboard.getPiece(destination).getPlayer() != getPlayer()) /*&& !kingIsPresent*/;
    }
}

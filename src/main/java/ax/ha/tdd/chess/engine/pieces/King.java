package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class King extends ChessPiece{
    public King(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return player.getSymbol();
    }

    @Override
    public boolean move(Chessboard chessboard, Coordinates destination) {
        if (canMove(chessboard, destination)) {
            location = destination;
            hasMoved = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        return (getLocation().getX() == destination.getX() && Math.abs(getLocation().getY() - destination.getY()) == 1 ||
                Math.abs(getLocation().getX() - destination.getX()) == 1 && getLocation().getY() == destination.getY() ||
                Math.abs(getLocation().getX() - destination.getX()) == 1 && Math.abs(getLocation().getY() - destination.getY()) == 1)
                && (chessboard.getPiece(destination) == null || chessboard.getPiece(destination).getPlayer() != getPlayer());
    }
}
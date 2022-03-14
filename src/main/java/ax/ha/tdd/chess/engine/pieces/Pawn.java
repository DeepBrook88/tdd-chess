package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Pawn extends ChessPiece{

    public Pawn(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    public boolean move(Chessboard chessboard, Coordinates destination) {
        if (canMove(chessboard, destination)) {
            location = destination;
            hasMoved = true;
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
    }

    @Override
    public boolean canMove(Chessboard chessboard, Coordinates destination) {
        int direction = player.equals(Player.WHITE) ? -1 : 1;
        if (location.getY() + direction * 2 == destination.getY()
                && !hasMoved
                && chessboard.getPiece(destination) == null) {
            return true;
        }
        return (location.getY() + direction == destination.getY()) && chessboard.getPiece(destination) == null;
    }
}

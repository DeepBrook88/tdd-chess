package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

public class Knight extends ChessPiece{

    public Knight(PieceType pieceType, Player player, Coordinates location) {
        super(pieceType, player, location);
    }

    @Override
    public String getSymbol() {
        return pieceType.getSymbol();
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
        int xPos = getLocation().getX();
        int yPos = getLocation().getY();
        int destXPos = destination.getX();
        int destYPos = destination.getY();
        boolean kingIsPresent = chessboard.getPiece(destination) != null && chessboard.getPiece(destination).pieceType.equals(PieceType.KING);
        return (chessboard.getPiece(destination) == null || chessboard.getPiece(destination).getPlayer() != getPlayer())
                && (xPos + 2 == destXPos && yPos + 1 == destYPos ||
                xPos + 2 == destXPos && yPos - 1 == destYPos ||
                xPos + 1 == destXPos && yPos + 2 == destYPos ||
                xPos + 1 == destXPos && yPos - 2 == destYPos ||
                xPos - 2 == destXPos && yPos + 1 == destYPos ||
                xPos - 2 == destXPos && yPos - 1 == destYPos ||
                xPos - 1 == destXPos && yPos + 2 == destYPos ||
                xPos - 1 == destXPos && yPos - 2 == destYPos) && !kingIsPresent;
    }
}

package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;

import java.util.ArrayList;
import java.util.List;

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
        // Against the other King
        int[] xOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] yOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        for (int i = 0; i < 8; i++) {
            ChessPiece king = chessboard.getPiece(new Coordinates(destination.getX() + xOffsets[i],destination.getY() + yOffsets[i]));
            if (king != null && king.pieceType.equals(PieceType.KING) && !king.player.equals(getPlayer())) return false;
        }
        // Against Pawns
        int pawnDirection = player.equals(Player.WHITE) ? -1 : 1;
        ChessPiece p1 = chessboard.getPiece(new Coordinates(destination.getX()-1,destination.getY()+pawnDirection));
        ChessPiece p2 = chessboard.getPiece(new Coordinates(destination.getX()+1,destination.getY()+pawnDirection));
        if (p1 != null && p1.pieceType.equals(PieceType.PAWN) || p2 != null && p2.pieceType.equals(PieceType.PAWN)) {
            return false;
        }
        // Against all other pieces
        List<ChessPiece> pieces = new ArrayList<>();
        for (ChessPiece[] chessPieces : chessboard) {
            for (ChessPiece chessPiece : chessPieces) {
                if (chessPiece != null && !chessPiece.player.equals(getPlayer()) && !chessPiece.pieceType.equals(PieceType.PAWN)) pieces.add(chessPiece);
            }
        }
        for (ChessPiece piece : pieces) {
            if (piece.canMove(chessboard, destination)) return false;
        }

        return (getLocation().getX() == destination.getX() && Math.abs(getLocation().getY() - destination.getY()) == 1 ||
                Math.abs(getLocation().getX() - destination.getX()) == 1 && getLocation().getY() == destination.getY() ||
                Math.abs(getLocation().getX() - destination.getX()) == 1 && Math.abs(getLocation().getY() - destination.getY()) == 1)
                && (chessboard.getPiece(destination) == null || chessboard.getPiece(destination).getPlayer() != getPlayer());
    }
}

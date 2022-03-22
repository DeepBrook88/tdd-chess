package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.ArrayList;
import java.util.List;

public class WinningConditionChecker {
    private WinningConditionChecker(){}
    public static WinningState checkState(Chessboard chessboard, Player player) {
        List<ChessPiece> pieces = new ArrayList<>();
        ChessPiece king = null;
        for (ChessPiece[] chessPieces : chessboard) {
            for (ChessPiece chessPiece : chessPieces) {
                if (chessPiece != null && !chessPiece.getPlayer().equals(player)
                        && !chessPiece.getPieceType().equals(PieceType.PAWN)
                        && !chessPiece.getPieceType().equals(PieceType.KING)) pieces.add(chessPiece);
                if (chessPiece != null && chessPiece.getPlayer().equals(player)
                        && chessPiece.getPieceType().equals(PieceType.KING)) king = chessPiece;
            }
        }
        for (ChessPiece piece : pieces) {
            if (king != null && piece.canThreatenKing(chessboard, king.getLocation())) return WinningState.CHECK;
        }
        return WinningState.PLAYING;
    }
}

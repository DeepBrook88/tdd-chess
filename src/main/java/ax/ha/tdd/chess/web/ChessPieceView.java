package ax.ha.tdd.chess.web;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;

public class ChessPieceView {

    private final ChessPiece chessPiece;

    public ChessPieceView(ChessPiece chessPiece) {
        this.chessPiece = chessPiece;
    }

    public String getUtf8Symbol() {
        return switch (chessPiece.getPlayer()) {
            case BLACK -> switch (chessPiece.getPieceType()) {
                case PAWN -> "♟";
                case ROOK -> "♜";
                case KNIGHT -> "♞";
                case BISHOP -> "♝";
                case QUEEN -> "♛";
                case KING -> "♚";
            };
            case WHITE -> switch (chessPiece.getPieceType()) {
                case PAWN -> "♙";
                case ROOK -> "♖";
                case KNIGHT -> "♘";
                case BISHOP -> "♗";
                case QUEEN -> "♕";
                case KING -> "♔";
            };
        };
    }
}

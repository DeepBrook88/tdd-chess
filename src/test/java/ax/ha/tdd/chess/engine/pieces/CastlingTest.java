package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastlingTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1","h1"})
    void validCastling(String move) {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates(move));
        board.addPiece(whiteKing);
        board.addPiece(whiteRook);
        whiteKing.castle(board, new Coordinates(move));
        assertEquals(new Coordinates(move),whiteKing.getLocation());
        assertEquals(new Coordinates("e1"),whiteRook.getLocation());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a1","h1"})
    void invalidCastlingKingHasMoved(String move) {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates(move));
        board.addPiece(whiteKing);
        board.addPiece(whiteRook);
        board.movePiece("e1-e2", Player.WHITE);
        board.movePiece("e2-"+move, Player.WHITE);
        assertEquals(new Coordinates("e2"),whiteKing.getLocation());
        assertEquals(new Coordinates(move),whiteRook.getLocation());
    }

    @Test
    void invalidCastlingRookHasMoved() {
        King blackKing = new King(PieceType.KING, Player.BLACK, new Coordinates("e8"));
        Rook blackRook = new Rook(PieceType.ROOK, Player.BLACK, new Coordinates("a8"));
        board.addPiece(blackKing);
        board.addPiece(blackRook);
        board.movePiece("a8-a2", Player.BLACK);
        board.movePiece("e8-a2", Player.BLACK);
        assertEquals(new Coordinates("e8"),blackKing.getLocation());
        assertEquals(new Coordinates("a2"),blackRook.getLocation());

    }
}

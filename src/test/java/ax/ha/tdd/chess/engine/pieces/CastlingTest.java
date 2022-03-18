package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
}

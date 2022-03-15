package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void moveYAxis() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a1"));
        board.addPiece(whiteRook);
        board.movePiece("a1-a8",Player.WHITE);
        assertEquals(new Coordinates("a8"),whiteRook.getLocation());
    }
}
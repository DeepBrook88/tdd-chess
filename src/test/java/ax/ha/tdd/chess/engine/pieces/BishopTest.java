package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void validDiagonalMove() {
        Bishop whiteBishop = new Bishop(PieceType.BISHOP, Player.WHITE, new Coordinates("c1"));
        board.addPiece(whiteBishop);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("f4"),whiteBishop.getLocation());
    }
    @Test
    void invalidMovement() {
        Bishop whiteBishop = new Bishop(PieceType.BISHOP, Player.WHITE, new Coordinates("c1"));
        board.addPiece(whiteBishop);
        board.movePiece("c1-g8",Player.WHITE);
        assertEquals(new Coordinates("c1"),whiteBishop.getLocation());
    }
}
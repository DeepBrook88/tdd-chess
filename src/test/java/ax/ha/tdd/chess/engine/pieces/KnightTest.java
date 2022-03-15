package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void validMovement() {
        Knight whiteKnight = new Knight(PieceType.KNIGHT, Player.WHITE, new Coordinates("d4"));
        board.addPiece(whiteKnight);
        board.movePiece("d4-e6",Player.WHITE);
        assertEquals(new Coordinates("e6"),whiteKnight.getLocation());
    }

    @Test
    void invalidMovement() {
        Knight whiteKnight = new Knight(PieceType.KNIGHT, Player.WHITE, new Coordinates("d4"));
        board.addPiece(whiteKnight);
        board.movePiece("d4-d6",Player.WHITE);
        assertEquals(new Coordinates("d4"),whiteKnight.getLocation());
    }
}
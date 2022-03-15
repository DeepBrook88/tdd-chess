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

    @Test
    void moveXAxis() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a1"));
        board.addPiece(whiteRook);
        board.movePiece("a1-h1",Player.WHITE);
        assertEquals(new Coordinates("h1"),whiteRook.getLocation());
    }

    @Test
    void moveYAxisAndCaptureBlack() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a1"));
        Rook blackRook = new Rook(PieceType.ROOK, Player.BLACK, new Coordinates("a8"));
        board.addPiece(whiteRook);
        board.addPiece(blackRook);
        board.movePiece("a1-a8",Player.WHITE);
        assertEquals(new Coordinates("a8"),whiteRook.getLocation());
    }

    @Test
    void moveXAxisAndCaptureWhite() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a1"));
        Rook blackRook = new Rook(PieceType.ROOK, Player.BLACK, new Coordinates("h1"));
        board.addPiece(whiteRook);
        board.addPiece(blackRook);
        board.movePiece("h1-a1",Player.BLACK);
        assertEquals(new Coordinates("a1"),blackRook.getLocation());
    }

    @Test
    void collideWithPieceInPathPositiveX() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a1"));
        Rook blackRook = new Rook(PieceType.ROOK, Player.BLACK, new Coordinates("f1"));
        board.addPiece(whiteRook);
        board.addPiece(blackRook);
        board.movePiece("a1-g1",Player.WHITE);
        assertEquals(new Coordinates("a1"),whiteRook.getLocation());
    }

    @Test
    void collideWithPieceInPathPositiveY() {
        Rook whiteRook = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("a8"));
        Rook blackRook = new Rook(PieceType.ROOK, Player.BLACK, new Coordinates("a5"));
        board.addPiece(whiteRook);
        board.addPiece(blackRook);
        board.movePiece("a8-a4",Player.WHITE);
        assertEquals(new Coordinates("a8"),whiteRook.getLocation());
    }
}
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
    @Test
    void captureEnemyPiece() {
        Bishop whiteBishop = new Bishop(PieceType.BISHOP, Player.WHITE, new Coordinates("c1"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("f4"));
        board.addPiece(whiteBishop);
        board.addPiece(blackPawn);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("f4"),whiteBishop.getLocation());
    }
    @Test
    void noCaptureOwnPiece() {
        Bishop whiteBishop = new Bishop(PieceType.BISHOP, Player.WHITE, new Coordinates("c1"));
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("f4"));
        board.addPiece(whiteBishop);
        board.addPiece(whitePawn);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("c1"),whiteBishop.getLocation());
    }
}
package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void validMoveXY() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        board.addPiece(whiteKing);
        board.movePiece("e1-e2",Player.WHITE);
        assertEquals(new Coordinates("e2"),whiteKing.getLocation());
        board.movePiece("e2-f2",Player.WHITE);
        assertEquals(new Coordinates("f2"),whiteKing.getLocation());
    }

    @Test
    void validMoveDiagonally() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        board.addPiece(whiteKing);
        board.movePiece("e1-f2",Player.WHITE);
        assertEquals(new Coordinates("f2"),whiteKing.getLocation());
    }

    @Test
    void invalidMove() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        board.addPiece(whiteKing);
        board.movePiece("e1-e5",Player.WHITE);
        assertEquals(new Coordinates("e1"),whiteKing.getLocation());
    }

    @Test
    void canCapture() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("e2"));
        board.addPiece(whiteKing);
        board.addPiece(blackPawn);
        board.movePiece("e1-e2",Player.WHITE);
        assertEquals(new Coordinates("e2"),whiteKing.getLocation());
    }
    @Test
    void noCaptureOwnPiece() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e2"));
        board.addPiece(whiteKing);
        board.addPiece(whitePawn);
        board.movePiece("e1-e2",Player.WHITE);
        assertEquals(new Coordinates("e1"),whiteKing.getLocation());
    }

    @Test
    void noSelfCheckVsPawn() {
        King whiteKing = new King(PieceType.KING, Player.WHITE, new Coordinates("e1"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("f3"));
        board.addPiece(whiteKing);
        board.addPiece(blackPawn);
        board.movePiece("e1-e2",Player.WHITE);
        assertEquals(new Coordinates("e1"),whiteKing.getLocation());
    }
}
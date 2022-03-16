package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void canMoveLikeBishop() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("d1"));
        board.addPiece(whiteQueen);
        board.movePiece("d1-g4",Player.WHITE);
        assertEquals(new Coordinates("g4"),whiteQueen.getLocation());
    }

    @Test
    void canMoveLikeRook() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("a1"));
        board.addPiece(whiteQueen);
        board.movePiece("a1-g1",Player.WHITE);
        assertEquals(new Coordinates("g1"),whiteQueen.getLocation());
    }

    @Test
    void invalidMovement() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("a1"));
        board.addPiece(whiteQueen);
        board.movePiece("a1-b3",Player.WHITE);
        assertEquals(new Coordinates("a1"),whiteQueen.getLocation());
    }

    @Test
    void noCaptureOwnPiece() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("c1"));
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("f4"));
        board.addPiece(whiteQueen);
        board.addPiece(whitePawn);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("c1"),whiteQueen.getLocation());
    }

    @Test
    void captureEnemyPiece() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("c1"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("f4"));
        board.addPiece(whiteQueen);
        board.addPiece(blackPawn);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("f4"),whiteQueen.getLocation());
    }

    @Test
    void noJumpOverOtherPieces() {
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("c1"));
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e3"));
        board.addPiece(whiteQueen);
        board.addPiece(whitePawn);
        board.movePiece("c1-f4",Player.WHITE);
        assertEquals(new Coordinates("c1"),whiteQueen.getLocation());
    }
}
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

    @Test
    void jumpOverOtherPieces() {
        Knight whiteKnight = new Knight(PieceType.KNIGHT, Player.WHITE, new Coordinates("d4"));
        Pawn whitePawn1 = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("d5"));
        Pawn whitePawn2 = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("e4"));
        board.addPiece(whiteKnight);
        board.addPiece(whitePawn1);
        board.addPiece(whitePawn2);
        board.movePiece("d4-e6",Player.WHITE);
        assertEquals(new Coordinates("e6"),whiteKnight.getLocation());
    }

    @Test
    void captureOnLandingSpot() {
        Knight whiteKnight = new Knight(PieceType.KNIGHT, Player.WHITE, new Coordinates("d4"));
        Pawn blackPawn1 = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("e6"));
        Pawn blackPawn2 = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("d5"));
        board.addPiece(whiteKnight);
        board.addPiece(blackPawn1);
        board.addPiece(blackPawn2);
        board.movePiece("d4-e6",Player.WHITE);
        assertEquals(new Coordinates("e6"),whiteKnight.getLocation());
        assertNotNull(board.getPiece(new Coordinates("d5")));
    }
}
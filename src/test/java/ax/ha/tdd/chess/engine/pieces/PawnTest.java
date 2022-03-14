package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Coordinates;
import ax.ha.tdd.chess.engine.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    private Chessboard board;

    @BeforeEach
    void setUp() {
        board = new Chessboard();
    }

    @Test
    void pawnForwardOnce() {
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("a5"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("a7"));
        board.addPiece(whitePawn);
        board.addPiece(blackPawn);
        board.movePiece("a5-a6",Player.WHITE);
        board.movePiece("a6-a7",Player.WHITE);
        assertEquals(new Coordinates("a6"),whitePawn.getLocation());
    }

    @Test
    void pawnFirstMoveTwoSpaces() {
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("a2"));
        Pawn blackPawn = new Pawn(PieceType.PAWN, Player.BLACK, new Coordinates("e7"));
        board.addPiece(whitePawn);
        board.addPiece(blackPawn);
        board.movePiece("a2-a4",Player.WHITE);
        board.movePiece("a4-a6",Player.WHITE);
        board.movePiece("a4-a5",Player.WHITE);

        board.movePiece("e7-e5",Player.BLACK);
        board.movePiece("e5-e3",Player.BLACK);
        board.movePiece("e5-e4",Player.BLACK);
        assertEquals(new Coordinates("a5"),whitePawn.getLocation());
        assertEquals(new Coordinates("e4"),blackPawn.getLocation());
    }

    @Test
    void pawnIllegalMovements() {
        Pawn whitePawn = new Pawn(PieceType.PAWN, Player.WHITE, new Coordinates("c2"));
        board.addPiece(whitePawn);
        board.movePiece("c2-b2", Player.WHITE);
        board.movePiece("c2-b3", Player.WHITE);
        board.movePiece("c2-c1", Player.WHITE);
        board.movePiece("c2-c4", Player.WHITE);
        assertEquals(new Coordinates("c4"), whitePawn.getLocation());
    }
}

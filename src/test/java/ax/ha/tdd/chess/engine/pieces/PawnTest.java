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
}

package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinStateCheckerTest {
    @Test
    void checkState_givenDefaultBoardAndBlackPlayer_expectPlaying() {
        assertEquals(WinningState.PLAYING,
                WinningConditionChecker.checkState(Chessboard.startingBoard(), Player.BLACK));
    }
    @Test
    void checkStateAndBlackPlayerExpectCheck() {
        Chessboard board = new Chessboard();
        King blackKing = new King(PieceType.KING, Player.BLACK, new Coordinates("e8"));
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("d1"));
        board.addPiece(blackKing);
        board.addPiece(whiteQueen);
        board.movePiece("d1-e2", Player.WHITE);
        assertEquals(WinningState.CHECK,
                WinningConditionChecker.checkState(board, Player.BLACK));
    }

    @Test
    void checkStateAndBlackPlayerExpectCheckMate() {
        Chessboard board = new Chessboard();
        King blackKing = new King(PieceType.KING, Player.BLACK, new Coordinates("e8"));
        Queen whiteQueen = new Queen(PieceType.QUEEN, Player.WHITE, new Coordinates("d1"));
        Rook whiteRook1 = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("d2"));
        Rook whiteRook2 = new Rook(PieceType.ROOK, Player.WHITE, new Coordinates("f1"));
        board.addPiece(blackKing);
        board.addPiece(whiteQueen);
        board.addPiece(whiteRook1);
        board.addPiece(whiteRook2);
        board.movePiece("d1-e2", Player.WHITE);
        assertEquals(WinningState.CHECKMATE,
                WinningConditionChecker.checkState(board, Player.BLACK));
    }
}

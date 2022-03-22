package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import ax.ha.tdd.chess.engine.pieces.Queen;
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
}

package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void checkmateForWhite() {
        Chessboard chessboard = Chessboard.startingBoard();
        String[] moves = {"f2-f3","e7-e5","g2-g4","d8-h4"};
        int turn = 0;
        for (String move : moves) {
            chessboard.movePiece(move, turn % 2 == 0 ? Player.WHITE : Player.BLACK);
            turn++;
        }
        assertEquals(WinningState.CHECKMATE, WinningConditionChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    void checkForWhite() {
        Chessboard chessboard = Chessboard.startingBoard();
        String[] moves = {"f2-f3","e7-e5","e2-e3","a7-a6","g2-g4","d8-h4"};
        int turn = 0;
        for (String move : moves) {
            chessboard.movePiece(move, turn % 2 == 0 ? Player.WHITE : Player.BLACK);
            turn++;
        }
        assertEquals(WinningState.CHECK, WinningConditionChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    void escapeCheckStateForWhite() {
        Chessboard chessboard = Chessboard.startingBoard();
        String[] moves = {"f2-f3","e7-e5","e2-e3","a7-a6","g2-g4","d8-h4","e1-e2"};
        int turn = 0;
        for (String move : moves) {
            chessboard.movePiece(move, turn % 2 == 0 ? Player.WHITE : Player.BLACK);
            turn++;
        }
        assertEquals(WinningState.PLAYING, WinningConditionChecker.checkState(chessboard,Player.WHITE));
    }

    @Test
    void escapeCheckStateForWhiteByCapture() {
        Chessboard chessboard = Chessboard.startingBoard();
        String[] moves = {"f2-f3","e7-e5","e2-e3","a7-a6","g2-g4","d8-h4","e1-e2","h4-f2","e2-f2"};
        int turn = 0;
        for (String move : moves) {
            chessboard.movePiece(move, turn % 2 == 0 ? Player.WHITE : Player.BLACK);
            turn++;
        }
        assertEquals(WinningState.PLAYING, WinningConditionChecker.checkState(chessboard,Player.WHITE));
    }
}

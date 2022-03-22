package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinStateCheckerTest {
    @Test
    void checkState_givenDefaultBoardAndBlackPlayer_expectPlaying() {
        assertEquals(WinningState.PLAYING,
                WinningConditionChecker.checkState(Chessboard.startingBoard(), Player.BLACK));
    }
}

package ax.ha.tdd.chess.engine;

public class WinningConditionChecker {
    private WinningConditionChecker(){}
    public static WinningState checkState(Chessboard chessboard, Player player) {
        return WinningState.PLAYING;
    }
}

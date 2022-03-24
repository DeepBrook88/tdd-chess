package ax.ha.tdd.chess.engine;

public class Game {

    Chessboard board = Chessboard.startingBoard();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;
    boolean successfulMove = false;
    String lastMove = "";
    int turn = 0;

    public Player getPlayerToMove() {
        return turn % 2 == 0 ? Player.WHITE : Player.BLACK;
    }

    public Chessboard getBoard() {
        return board;
    }

    public String getLastMoveResult() {
        //Illegal move, correct move, e2 moved to e4 etc.
        if (isNewGame) {
            return "Game hasn't begun";
        }
        else if(successfulMove) {
            return "Last move was successful: " + lastMove;
        }
        return "Invalid move, reason: " + lastMove;
    }

    public void move(String move) {
        isNewGame = false;
        try {
            System.out.println("Player " + getPlayerToMove().getSymbol() + " tried to perform move: " + move);
            successfulMove = board.movePiece(move, getPlayerToMove());
            turn += successfulMove ? 1 : 0;
            lastMove = move;
            WinningState state = WinningConditionChecker.checkState(board,getPlayerToMove());
            lastMove += state.equals(WinningState.CHECK) ? " CHECK" : "";
            lastMove += state.equals(WinningState.CHECKMATE) ? " CHECKMATE" : "";
        } catch (Exception e) {
            successfulMove = false;
            lastMove = e.getMessage();
        }
    }
}

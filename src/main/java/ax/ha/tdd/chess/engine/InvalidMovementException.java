package ax.ha.tdd.chess.engine;

public class InvalidMovementException extends RuntimeException {

    public InvalidMovementException(String message) {
        super(message);
    }
}

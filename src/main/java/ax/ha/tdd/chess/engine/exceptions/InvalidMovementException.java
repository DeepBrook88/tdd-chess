package ax.ha.tdd.chess.engine.exceptions;

public class InvalidMovementException extends RuntimeException {

    public InvalidMovementException(String message) {
        super(message);
    }
}

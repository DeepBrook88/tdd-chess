package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;

import java.util.Iterator;
import java.util.List;

public class Chessboard implements Iterable<ChessPiece[]> {
    // This could just as easily be replaced with a List or Set,
    // since the ChessPieces right now keep track of their own location.
    // Feel free to change this however you like
    // [y][x]
    private final ChessPiece[][] board = new ChessPiece[8][8];

    public static Chessboard startingBoard() {
        final Chessboard chessboard = new Chessboard();

        chessboard.withMirroredPiece(PieceType.PAWN, List.of(0,1,2,3,4,5,6,7), 1)
                .withMirroredPiece(PieceType.ROOK, List.of(0,7), 0)
                .withMirroredPiece(PieceType.KNIGHT, List.of(1,6), 0)
                .withMirroredPiece(PieceType.BISHOP, List.of(2,5), 0)
                .withMirroredPiece(PieceType.QUEEN, List.of(3), 0)
                .withMirroredPiece(PieceType.KING, List.of(4), 0);
        return chessboard;
    }

    public ChessPiece getPiece(final Coordinates coordinates) {
        return board[coordinates.getY()][coordinates.getX()];
    }

    public void addPiece(final ChessPiece chessPiece) {
        board[chessPiece.getLocation().getY()][chessPiece.getLocation().getX()] = chessPiece;
    }

    public boolean movePiece(String move, Player player) {
        String[] moves = move.split("-");
        ChessPiece a = getPiece(new Coordinates(moves[0]));
        if (a == null) throw new InvalidMovementException("no piece located");
        if(!a.getPlayer().equals(player)) throw new InvalidMovementException("Cannot move other players pieces");
        Coordinates aPos = a.getLocation();
        if(a.move(this, new Coordinates(moves[1]))) {
            board[aPos.getY()][aPos.getX()] = null;
            board[a.getLocation().getY()][a.getLocation().getX()] = a;
            return true;
        }
        return false;
    }

    /**
     * Helper method to initialize chessboard with {@link ChessPieceStub}.
     * Basically mirrors all added pieces for both players.
     * When all pieces has been implemented, this should be replaced with the proper implementations.
     *
     * @param pieceType pieceType
     * @param xCoordinates xCoordinates
     * @param yCoordinate yCoordinateOffset
     * @return itself, like a builder pattern
     */
    private Chessboard withMirroredPiece(final PieceType pieceType,
                                         final List<Integer> xCoordinates, final int yCoordinate) {
        xCoordinates.forEach(xCoordinate -> {
            if(pieceType.equals(PieceType.PAWN)) {
                addPiece(new Pawn(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                addPiece(new Pawn(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
            }
            else {
                addPiece(new ChessPieceStub(pieceType, Player.BLACK, new Coordinates(xCoordinate, yCoordinate)));
                addPiece(new ChessPieceStub(pieceType, Player.WHITE, new Coordinates(xCoordinate, 7 - yCoordinate)));
            }
        });
        return this;
    }

    @Override
    public Iterator<ChessPiece[]> iterator() {
        return List.of(board).iterator();
    }
}

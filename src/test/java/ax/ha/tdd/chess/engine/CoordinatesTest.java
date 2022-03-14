package ax.ha.tdd.chess.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoordinatesTest {

    @Test
    public void equals_givenSameArgument_expectObjectEquals() {
        Assertions.assertEquals(new Coordinates(0, 7), new Coordinates(0, 7));
    }

    @Test
    public void Coordinates_givenAlgebraicNotation_expectMatchingCoordinates() {
        Assertions.assertEquals(new Coordinates("a1"), new Coordinates(0, 7));
        Assertions.assertEquals(new Coordinates("f3"), new Coordinates(5, 5));
        Assertions.assertEquals(new Coordinates("a8"), new Coordinates(0, 0));
        Assertions.assertEquals(new Coordinates("g8"), new Coordinates(6, 0));
    }

    @Test
    public void Coordinates_givenBadAlgebraicNotation_expectIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("A1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("I1");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("a0");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates("a9");
        });
    }


    @Test
    public void Coordinates_givenBadIndexes_expectIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(-1,1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(0,-1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(8,0);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(0,8);
        });
    }
}
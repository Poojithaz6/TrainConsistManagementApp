import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestCase {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        int total = CapacityCalculator.totalSeats(bogies);
        assertEquals(152, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 72)
        );

        assertEquals(144, CapacityCalculator.totalSeats(bogies));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24)
        );

        assertEquals(24, CapacityCalculator.totalSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        assertEquals(0, CapacityCalculator.totalSeats(bogies));
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 20)
        );

        int expected = 70 + 50 + 20;
        assertEquals(expected, CapacityCalculator.totalSeats(bogies));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        CapacityCalculator.totalSeats(bogies);

        assertEquals(1, bogies.size()); // list unchanged
    }
}
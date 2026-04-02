import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class UC13Test {

    List<Bogie> sampleData() {
        return List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 80)
        );
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = PerformanceChecker.filterWithLoop(sampleData());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = PerformanceChecker.filterWithStream(sampleData());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = PerformanceChecker.filterWithLoop(sampleData());
        List<Bogie> streamResult = PerformanceChecker.filterWithStream(sampleData());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long time = PerformanceChecker.measureTime(() ->
                PerformanceChecker.filterWithLoop(sampleData())
        );

        assertTrue(time > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> large = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            large.add(new Bogie("Sleeper", i % 100));
        }

        List<Bogie> result = PerformanceChecker.filterWithStream(large);
        assertNotNull(result);
    }
}
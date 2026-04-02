import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Large dataset
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        long loopTime = PerformanceChecker.measureTime(() ->
                PerformanceChecker.filterWithLoop(bogies)
        );

        long streamTime = PerformanceChecker.measureTime(() ->
                PerformanceChecker.filterWithStream(bogies)
        );

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");
    }
}
import java.util.List;

public class CapacityCalculator {

    public static int totalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }
}

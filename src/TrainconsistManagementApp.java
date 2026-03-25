import java.util.ArrayList;
import java.util.List;

public class TrainconsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Bogies after addition: " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("Bogies after removal: " + passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");

        System.out.println("Does Sleeper exist? " + exists);
    }
}

import java.util.Arrays;

public class TrainConsistApp {

    // Search with validation (Binary Search reused)
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ✅ Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // Sort before binary search
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309"};

        try {
            boolean found = searchBogie(bogieIds, "BG205");

            if (found) {
                System.out.println("Bogie found.");
            } else {
                System.out.println("Bogie not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues normally...");
    }
}
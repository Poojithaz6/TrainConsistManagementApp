import java.util.Arrays;

public class TrainConsistApp {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds.length == 0) {
            return false;
        }

        // Ensure sorted (important precondition)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // found
            } else if (comparison < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";

        boolean found = binarySearch(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " found.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        System.out.println("Program continues normally...");
    }
}
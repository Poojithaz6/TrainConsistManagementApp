import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );

        boolean isSafe = SafetyChecker.isSafe(bogies);

        if (isSafe) {
            System.out.println("Train is SAFE");
        } else {
            System.out.println("Train is NOT SAFE");
        }
    }
}
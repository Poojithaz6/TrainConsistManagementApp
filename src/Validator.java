public class Validator {

    public static boolean isValidTrainId(String id) {
        return id != null && id.matches("TRN-\\d{4}");
    }

    public static boolean isValidCargoCode(String code) {
        return code != null && code.matches("PET-[A-Z]{2}");
    }
}
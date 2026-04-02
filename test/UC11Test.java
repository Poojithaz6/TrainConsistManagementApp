import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC11Test {

    @Test
    void testValidTrainId() {
        assertTrue(Validator.isValidTrainId("TRN-1234"));
    }

    @Test
    void testInvalidTrainId() {
        assertFalse(Validator.isValidTrainId("TRN12A"));
    }

    @Test
    void testValidCargoCode() {
        assertTrue(Validator.isValidCargoCode("PET-AB"));
    }

    @Test
    void testInvalidCargoCode() {
        assertFalse(Validator.isValidCargoCode("PET-ab"));
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC14Test {

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistApp.GoodsBogie bogie =
                new TrainConsistApp.GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistApp.GoodsBogie bogie =
                new TrainConsistApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistApp.GoodsBogie bogie =
                new TrainConsistApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistApp.GoodsBogie bogie =
                new TrainConsistApp.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum"); // fails
        bogie.assignCargo("Coal");      // should succeed

        assertEquals("Coal", bogie.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistApp.GoodsBogie bogie =
                new TrainConsistApp.GoodsBogie("Rectangular");

        // We can't directly assert finally block,
        // but execution reaching here proves no crash
        bogie.assignCargo("Petroleum");

        assertTrue(true);
    }
}
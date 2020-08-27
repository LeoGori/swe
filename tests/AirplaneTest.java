import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AirplaneTest {

    private Airplane airplane;

    @BeforeEach
    void setUp() {
        airplane = new Airplane(100, 200, 300);
    }

    @Test
    void getSeatsNum() {
        assertEquals(airplane.getSeatsNum(), 100);
    }

    @Test
    void getAvailableSeats() {
        assertEquals(airplane.getAvailableSeats(), 100);
    }

    @org.junit.jupiter.api.Test
    void getHoldRoomCapability() {
        assertEquals(airplane.getHoldRoomCapability(), 200);
    }

    @org.junit.jupiter.api.Test
    void getHoldWeightCapability() {
        assertEquals(airplane.getHoldWeightCapability(), 300);
    }

    @org.junit.jupiter.api.Test
    void removeSeat() {
        airplane.removeSeat();
        assertEquals(airplane.getAvailableSeats(), 99);
    }
}
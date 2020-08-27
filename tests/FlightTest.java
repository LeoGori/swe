import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight(2302, "Milano", "Roma");
    }

    @Test
    void testEquals() {
        assertEquals(flight, new Flight(2302, "Milano", "Roma"));
    }

    @Test
    void getDestination() {
        assertEquals(flight.getDestination(), "Milano");
    }

    @Test
    void removeAvailableSeat() {
        flight.removeAvailableSeat();
        assertEquals(flight.getAirplane().getSeatsNum() - 1, flight.getAirplane().getAvailableSeats());
    }
}
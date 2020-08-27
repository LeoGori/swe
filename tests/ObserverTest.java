import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {

    private Airport airport;
    private Customer customer;
    private ReservableProxy reservableProxy;
    private Flight flight1, flight2;

    @BeforeEach
    void setUp() {
        airport = new Airport("Firenze");
        reservableProxy = new ReservableProxy();
        flight1 = new Flight(1732, "Roma", airport.getName());
        flight2 = new Flight(3845, "Milano", airport.getName());
        airport.getFlightTable().addFlight(flight1);
        airport.getFlightTable().addFlight(flight2);
        RealReservableFlightArchive.getInstance().addAirport(airport);
        customer = new Customer("Miriam", "789");
    }

    @Test
    void testObserver() {
        reservableProxy.addUser(customer);
        reservableProxy.setReservation(customer, flight1);
        reservableProxy.setReservation(customer, flight2);

        Reservation reservation = new Reservation();
        reservation.addFlight(flight1);
        reservation.addFlight(flight2);

        assertEquals(reservableProxy.getReservation(customer), reservation);

        airport.getFlightTable().removeFlight(flight1);
        reservation.removeFlight(flight1);

        assertEquals(reservableProxy.getReservation(customer), reservation);

    }
}

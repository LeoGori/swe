import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class ReservableProxyTest {
    
    private Customer customer1, customer2;
    private ReservableProxy reservableProxy;
    
    @BeforeEach
    void setUp() {
        customer1 = new Customer("Bernardo" , "123");
        customer2 = new Customer("Anna", "456");
        reservableProxy = new ReservableProxy();
    }

    @Test
    void addUser() {
        ArrayList<Customer> customers = new ArrayList();
        customers.add(customer1);
        reservableProxy.addUser(customer1);

        assertEquals(reservableProxy.getCustomers(), customers);

        customers.add(customer2);
        reservableProxy.addUser(customer2);

        assertEquals(reservableProxy.getCustomers(), customers);
    }

    @Test
    void setReservation() {
        reservableProxy.addUser(customer1);
        reservableProxy.setReservation(customer1, new Flight(2304, "Milano", "Roma"));
        Reservation reservation = new Reservation();
        reservation.addFlight(new Flight(2304, "Milano", "Roma"));

        assertEquals(reservableProxy.getReservation(customer1), reservation);
        assertEquals(reservableProxy.getReservation(new Customer("Bernardo" , "456")), null);
    }

    @Test
    void removeReservation() {
        reservableProxy.addUser(customer1);
        reservableProxy.removeReservation(customer1, new Flight(2304, "Milano", "Roma"));
        Reservation reservation = new Reservation();

        assertEquals(reservableProxy.getReservation(customer1), reservation);
    }
}
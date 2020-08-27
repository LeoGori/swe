import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("paolo", "password");
    }

    @Test
    void testEquals() {
        assertEquals(customer, new Customer("paolo", "password"));
    }

    @Test
    void getUsername() {
        assertEquals(customer.getUsername(), "paolo");
    }

    @Test
    void getPassword() {
        assertEquals(customer.getPassword(), "password");
    }
}
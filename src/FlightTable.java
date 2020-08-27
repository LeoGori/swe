import java.util.ArrayList;
import java.util.Observable;

public class FlightTable extends Observable{

    ArrayList<Flight> flights;

    public void removeFlight(Flight flight) {
        flights.remove(flight);
        setChanged();
        notifyObservers(flight);
    }

    public FlightTable() {
        flights = new ArrayList();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
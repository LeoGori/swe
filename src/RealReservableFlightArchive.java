import java.util.*;

public class RealReservableFlightArchive implements ReservableFlightArchive {

    private HashMap<Customer, Reservation> reservations;
    private ArrayList<Airport> airports;
    private static RealReservableFlightArchive instance;

    private RealReservableFlightArchive() {
        reservations = new HashMap<>();
        airports = new ArrayList<>();
    }

    public static RealReservableFlightArchive getInstance() {
        if(instance == null)
            instance = new RealReservableFlightArchive();
        return instance;
    }

    public void addAirport(Airport airport) {
        airports.add(airport);
    }

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList();
        for(Airport airport : airports )
            flights.addAll(airport.getFlightTable().getFlights());
        return flights;
    }

    public ArrayList<Flight> getFlights(int id) {
        ArrayList<Flight> flights = new ArrayList();
            flights.addAll(airports.get(id).getFlightTable().getFlights());
        return flights;
    }

    @Override
    public Reservation getReservation(Customer customer) {
        return reservations.get(customer);
    }

    @Override
    public void setReservation(Customer customer, Flight flight) {
        reservations.get(customer).addFlight(flight);
        for(Airport airport : airports) {
            if(airport.getFlightTable().getFlights().contains(flight))
                airport.getFlightTable().addObserver(reservations.get(customer));        }
    }

    public void addUser(Customer customer) {
        reservations.put(customer, new Reservation());
    }

    public void removeReservation(Customer customer, Flight flight) {
        reservations.get(customer).removeFlight(flight);
    }
}
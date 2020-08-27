import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Reservation implements Observer {

    private ArrayList<Flight> flights = new ArrayList<>();

    @Override
    public void update(Observable o, Object arg) {
        Flight flight = (Flight) arg;
        if(flights.contains(flight)) {
            flights.remove(flight);
            System.out.println("Il " + flight + " è stato annullato");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Reservation){
            Reservation reservation = (Reservation) obj;
            if(reservation != null && this.flights.equals(reservation.flights)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Hai prenotato per i seguenti voli:\n" + flights;
    }

    public void addFlight(Flight flight) {
        if(flights.contains(flight))
                System.out.print("Il volo è già stato prenotato da questo utente");
        else {
            flights.add(flight);
            flights.get(flights.indexOf(flight)).removeAvailableSeat();
        }
    }

    public void removeFlight(Flight flight) {
        if(!flights.contains(flight))
            System.out.print("Il volo selezionato non è stato ancora prenotato");
        else
            flights.remove(flight);
    }

    public ArrayList<Flight> getFlights(){
        return flights;
    }
}

import java.util.ArrayList;

public class ReservableProxy implements ReservableFlightArchive{

    private ArrayList <Customer> customers;

    public ReservableProxy(){
        customers = new ArrayList<>();
    }

    public void addUser(Customer customer){
        if(customers.contains(customer))
            System.out.println("password non disponibile");
        else {
            customers.add(customer);
            RealReservableFlightArchive.getInstance().addUser(customer);
        }
    }

    @Override
    public Reservation getReservation(Customer customer) {
        if(customers.contains(customer))
            return RealReservableFlightArchive.getInstance().getReservation(customer);
        else {
            System.out.println("utente non riconosciuto, per poter prenotare, annullare un volo o visualizzare le prenotazioni è necessario registrarsi");
            return null;
        }
    }

    @Override
    public void setReservation(Customer customer, Flight flight) {
        if(customers.contains(customer))
            RealReservableFlightArchive.getInstance().setReservation(customer, flight);
        else {
            System.out.println("utente non riconosciuto, per poter prenotare o annullare un volo o visualizzare le prenotazioni è necessario registrarsi");
        }
    }

    public void removeReservation(Customer customer, Flight flight) {
        if(customers.contains(customer))
            RealReservableFlightArchive.getInstance().removeReservation(customer, flight);
        else {
            System.out.println("utente non riconosciuto, per poter prenotare o annullare un volo o visualizzare le prenotazioni è necessario registrarsi");
        }
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }
}

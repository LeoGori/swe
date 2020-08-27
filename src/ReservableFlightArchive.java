public interface ReservableFlightArchive {

    Reservation getReservation(Customer customer);
    void setReservation(Customer customer, Flight flight);
    void removeReservation(Customer customer, Flight flight);
}
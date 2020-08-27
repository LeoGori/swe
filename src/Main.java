import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean loop = true;
        Scanner scan = new Scanner(System.in);
        ReservableProxy reservableProxy = new ReservableProxy();

        Airport airport1 = new Airport("Firenze");
        Airport airport2 = new Airport("Milano");

        airport1.getFlightTable().addFlight(new Flight(1732, "Roma", airport1.getName()));
        airport1.getFlightTable().addFlight(new Flight(3845, "Milano", airport1.getName()));

        airport2.getFlightTable().addFlight(new Flight(9023, "Parigi", airport2.getName()));
        airport2.getFlightTable().addFlight(new Flight(4264, "Bruxelles", airport2.getName()));
        airport2.getFlightTable().addFlight(new Flight(5142, "Firenze", airport2.getName()));

        RealReservableFlightArchive.getInstance().addAirport(airport1);
        RealReservableFlightArchive.getInstance().addAirport(airport2);

        while(loop){
            System.out.println(RealReservableFlightArchive.getInstance().getFlights());

            System.out.println("1)Registrati\n" + "2)Prenota volo\n" + "3)Annulla prenotazione\n" + "4)Esci");
            int choice = Integer.parseInt(scan.next());

            switch(choice){
                case 1 -> {
                    System.out.print("Introduci nome utente: ");
                    String nomeUtente = scan.next();

                    System.out.print("Introduci password: ");
                    String password = scan.next();

                    Customer customer = new Customer(nomeUtente, password);

                    reservableProxy.addUser(customer);
                }

                case 2 -> {

                    System.out.println("Scegli Aeroporto: ");
                    System.out.println(RealReservableFlightArchive.getInstance().getAirports());

                    int aeroportoId = Integer.parseInt(scan.next());

                    System.out.println(RealReservableFlightArchive.getInstance().getFlights(aeroportoId));

                    System.out.println("Scegli il volo da prenotare: ");
                    int flightId = Integer.parseInt(scan.next());

                    Flight flight = RealReservableFlightArchive.getInstance().getFlights(aeroportoId).get(flightId);

                    System.out.print("Per continuare la prenotazione è necessario autenticarsi. Introduci nome utente: ");
                    String nomeUtente = scan.next();

                    System.out.print("Introduci password: ");
                    String password = scan.next();

                    reservableProxy.setReservation(new Customer(nomeUtente, password), flight);

                    System.out.println(reservableProxy.getReservation(new Customer(nomeUtente, password)));

                }

                case 3 -> {

                    System.out.println("Per continuare è necessario autenticarsi");
                    System.out.print("Introduci nome utente: ");
                    String nomeUtente = scan.next();

                    System.out.print("Introduci password: ");
                    String password = scan.next();

                    System.out.println(reservableProxy.getReservation(new Customer(nomeUtente, password)));

                    System.out.println("Scegli la prenotazione da annullare: ");
                    int flightId = Integer.parseInt(scan.next());

                    Flight flight = reservableProxy.getReservation(new Customer(nomeUtente, password)).getFlights().get(flightId);

                    reservableProxy.removeReservation(new Customer(nomeUtente, password), flight);

                    System.out.println(reservableProxy.getReservation(new Customer(nomeUtente, password)));
                }

                case 4 -> {
                    loop = false;
                }

            }

            System.out.println(reservableProxy.getCustomers());
        }

        airport1.getFlightTable().removeFlight(new Flight(1732, "Roma", airport1.getName()));
    }
}

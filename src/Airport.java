public class Airport {
    FlightTable flightTable;
    String name;

    public String getName() {
        return name;
    }

    public Airport(String name) {
        this.name = name;
        flightTable = new FlightTable();
    }

    public FlightTable getFlightTable() {
        return flightTable;
    }

    @Override
    public String toString() {
        return name;
    }
}

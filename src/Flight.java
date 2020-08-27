class Flight {

    private String departure;
    private String destination;
    private Airplane airplane;
    private int id;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Flight){
            Flight flight = (Flight) obj;
            if(flight != null && this.destination.equals(flight.destination) && this.id == flight.id){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Volo n." + id + " con partenza da " + departure + " con destinazione a " + destination;
    }

    public Flight(int id, String destination, String departure) {
        this.destination = destination;
        this.departure = departure;
        this.id = id;
        this.airplane = new Airplane(100, 200, 300);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void removeAvailableSeat(){
        airplane.removeSeat();
    }

    public Airplane getAirplane() {
        return airplane;
    }
}

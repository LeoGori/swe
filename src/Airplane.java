public class Airplane {

    private int seatsNum;
    private int holdRoomCapability;
    private int holdWeightCapability;
    private int availableSeats;

    public int getAvailableSeats() {
        return availableSeats;
    }

    public Airplane(int seatsNum, int holdRoomCabability, int holdWeightCapability) {
        this.seatsNum = this.availableSeats =  seatsNum;
        this.holdRoomCapability = holdRoomCabability;
        this.holdWeightCapability = holdWeightCapability;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public int getHoldRoomCapability() {
        return holdRoomCapability;
    }

    public int getHoldWeightCapability() {
        return holdWeightCapability;
    }

    public void removeSeat() {
        availableSeats --;
        holdWeightCapability -= (holdWeightCapability/seatsNum);
        holdRoomCapability -= (holdRoomCapability/seatsNum);
    }
}

package model;

// 負責：成員4（座位）
public class EconomySeat extends Seat {

    public EconomySeat(String seatNo) {
        super(seatNo);
    }

    @Override
    public SeatClass getSeatClass() { return SeatClass.ECONOMY; }

    @Override
    public int getFreeBaggageKg() { return 23; }
}

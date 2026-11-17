package model;

// 負責：成員4（座位）
public class BusinessSeat extends Seat {

    public BusinessSeat(String seatNo) {
        super(seatNo);
    }

    @Override
    public SeatClass getSeatClass() { return SeatClass.BUSINESS; }

    @Override
    public int getFreeBaggageKg() { return 32; }
}

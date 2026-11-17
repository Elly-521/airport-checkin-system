package model;

import java.util.ArrayList;
import java.util.List;

// 負責：成員3（旅客與訂位）
// 關聯 Passenger 和 Flight
public class Booking {
    private String bookingRef;
    private Passenger passenger;
    private Flight flight;
    private SeatClass seatClass;
    private Seat seat;                              // 報到時才分配
    private List<Baggage> baggages = new ArrayList<>();
    private boolean cancelled = false;

    public Booking(String bookingRef, Passenger passenger, Flight flight, SeatClass seatClass) {
        this.bookingRef = bookingRef;
        this.passenger = passenger;
        this.flight = flight;
        this.seatClass = seatClass;
    }

    public String getBookingRef() { return bookingRef; }
    public Passenger getPassenger() { return passenger; }
    public Flight getFlight() { return flight; }
    public SeatClass getSeatClass() { return seatClass; }
    public Seat getSeat() { return seat; }
    public List<Baggage> getBaggages() { return baggages; }
    public boolean isCancelled() { return cancelled; }

    public void setSeat(Seat seat) { this.seat = seat; }
    public void addBaggage(Baggage baggage) { baggages.add(baggage); }

    // TODO（加強）：取消訂位，已報到的不能取消
    public void cancel() {
    }
}

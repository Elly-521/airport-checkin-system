package model;

// 負責：C
// 關聯 Passenger 和 Flight
public class Booking {
    private String bookingRef;
    private Passenger passenger;
    private Flight flight;
    private SeatClass seatClass;

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
}

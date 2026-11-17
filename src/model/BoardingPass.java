package model;

import java.time.LocalDateTime;

// 負責：E
public class BoardingPass implements Printable {
    private String passNo;
    private Booking booking;
    private Seat seat;
    private LocalDateTime boardingTime;

    public BoardingPass(String passNo, Booking booking, Seat seat) {
        this.passNo = passNo;
        this.booking = booking;
        this.seat = seat;
        // TODO: 登機時間 = 起飛前 30 分鐘
        this.boardingTime = booking.getFlight().getDepartureTime().minusMinutes(30);
    }

    public String getPassNo() { return passNo; }
    public Booking getBooking() { return booking; }
    public Seat getSeat() { return seat; }
    public LocalDateTime getBoardingTime() { return boardingTime; }

    @Override
    public void print() {
        // TODO: 印出漂亮的登機證格式（姓名、航班、座位、登機門、登機時間）
    }
}

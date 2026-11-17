package model;

import java.time.LocalDateTime;

// 負責：成員6（登機證與登機）
public class BoardingPass implements Printable {
    private String passNo;
    private Booking booking;
    private LocalDateTime boardingTime;

    public BoardingPass(String passNo, Booking booking) {
        this.passNo = passNo;
        this.booking = booking;
        // 登機時間 = 起飛前 30 分鐘
        this.boardingTime = booking.getFlight().getDepartureTime().minusMinutes(30);
    }

    public String getPassNo() { return passNo; }
    public Booking getBooking() { return booking; }
    public LocalDateTime getBoardingTime() { return boardingTime; }

    @Override
    public void print() {
        // TODO: 印出登機證（姓名、航班、座位、登機門、登機時間）
    }
}

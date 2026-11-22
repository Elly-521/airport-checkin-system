package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Flight flight = booking.getFlight();
        Seat seat = booking.getSeat();

        System.out.println("========== 登機證 ==========");
        System.out.println("登機證號：" + passNo);
        System.out.println("姓名    ：" + booking.getPassenger().getName());
        System.out.println("航班    ：" + flight.getFlightNo()
            + "  " + flight.getOrigin() + " → " + flight.getDestination());
        System.out.println("座位    ：" + (seat == null ? "未劃位" : seat.getSeatNo()));
        System.out.println("登機門  ：" + flight.getGate());
        System.out.println("登機時間：" + boardingTime.format(fmt));
        System.out.println("============================");
        // TODO: 印出登機證（姓名、航班、座位、登機門、登機時間）
    }
}

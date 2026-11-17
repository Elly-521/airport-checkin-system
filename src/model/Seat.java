package model;

// 負責：C
public class Seat {
    private String seatNo;      // 例如 "12A"
    private SeatClass seatClass;
    private boolean available = true;

    public Seat(String seatNo, SeatClass seatClass) {
        this.seatNo = seatNo;
        this.seatClass = seatClass;
    }

    public String getSeatNo() { return seatNo; }
    public SeatClass getSeatClass() { return seatClass; }
    public boolean isAvailable() { return available; }

    // TODO: 已被佔用時應該拋出例外或回傳 false
    public void occupy() { available = false; }
}

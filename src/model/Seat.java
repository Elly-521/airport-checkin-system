package model;

// 負責：成員4（座位）
// 抽象類別：不同艙等的座位繼承它（多型展示重點）
public abstract class Seat {
    private String seatNo;          // 例如 "12A"
    private boolean available = true;
    private int kg;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatNo() { return seatNo; }
    public boolean isAvailable() { return available; }

    // TODO: 已被佔用時丟出 IllegalStateException
    public void occupy() {
        available = false;
    }

    // 子類別各自實作
    public abstract SeatClass getSeatClass();
    public abstract int getFreeBaggageKg();   // 免費託運公斤數

    @Override
    public String toString() {
        return seatNo + "(" + getSeatClass() + (available ? "" : ", 已佔用") + ")";
    }
}

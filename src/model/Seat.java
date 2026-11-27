package model;

// 負責：成員4（座位）
// 抽象類別：不同艙等的座位繼承它（多型展示重點）
public abstract class Seat {
    private String seatNo;          // 例如 "12A"
    private boolean available = true;

    public Seat(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatNo() { return seatNo; }
    public boolean isAvailable() { return available; }

    // TODO: 已被佔用時丟出 IllegalStateException
    //佔用座位
    public void occupy() {
        if(available == false){
            throw new IllegalStateException("Seat "+seatNo+" is already occupied.");
        }
        available = false;
    }

    //釋放座位
    public void release(){
        if(available){
            throw new IllegalStateException("Seat "+seatNo+" is not occupied, cannot release");
        }
        available = true;
    }

    // 子類別各自實作
    public abstract SeatClass getSeatClass();
    public abstract int getFreeBaggageKg();   // 免費託運公斤數

    @Override
    public String toString() {
        return seatNo + "(" + getSeatClass() + (available ? "" : ", 已佔用") + ")";
    }
}

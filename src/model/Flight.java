package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 負責：成員2（航班）
// Flight 和 Seat 是組合關係：座位隨航班建立
public class Flight {
    private String flightNo;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private String gate;
    private boolean cancelled = false;
    private List<Seat> seats = new ArrayList<>();

    public Flight(String flightNo, String origin, String destination,
                  LocalDateTime departureTime, String gate) {
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
    }

    public String getFlightNo() { return flightNo; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public String getGate() { return gate; }
    public boolean isCancelled() { return cancelled; }
    public List<Seat> getSeats() { return seats; }

    public void addSeat(Seat seat) { seats.add(seat); }

    // TODO: 修改登機門
    public void changeGate(String newGate) {
        this.gate = newGate;
    }

    // TODO: 航班延誤，起飛時間往後延 minutes 分鐘
    public void delay(int minutes) {
    }

    // TODO（加強）：取消航班
    public void cancel() {
    }

    // TODO: 用座位號碼找座位，找不到回傳 null
    public Seat findSeat(String seatNo) {
        return null;
    }

    // TODO: 印出航班資訊
    @Override
    public String toString() {
        return flightNo + " " + origin + " → " + destination;
    }
}

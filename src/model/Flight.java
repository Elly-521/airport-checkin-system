package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 負責：成員2（航班）
// Flight 和 Seat 是組合關係：座位隨航班建立
public class Flight {
    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private String flightNo;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private String gate;
    private boolean cancelled = false;
    private List<Seat> seats = new ArrayList<>();

    public Flight(String flightNo, String origin, String destination,
                  LocalDateTime departureTime, String gate) {
        if (flightNo == null || flightNo.isBlank()) {
            throw new IllegalArgumentException("航班編號不能是空的");
        }
        if (departureTime == null) {
            throw new IllegalArgumentException("起飛時間不能是空的");
        }
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

    // 新增座位，座位號碼不能重複
    public void addSeat(Seat seat) {
        if (findSeat(seat.getSeatNo()) != null) {
            throw new IllegalArgumentException("座位 " + seat.getSeatNo() + " 已經存在");
        }
        seats.add(seat);
    }

    // 修改登機門
    public void changeGate(String newGate) {
        checkNotCancelled();
        if (newGate == null || newGate.isBlank()) {
            throw new IllegalArgumentException("登機門不能是空的");
        }
        this.gate = newGate.trim().toUpperCase();
    }

    // 航班延誤，起飛時間往後延 minutes 分鐘
    public void delay(int minutes) {
        checkNotCancelled();
        if (minutes <= 0) {
            throw new IllegalArgumentException("延誤分鐘數必須大於 0");
        }
        this.departureTime = departureTime.plusMinutes(minutes);
    }

    // （加強）取消航班：取消後不能再報到、改登機門或延誤
    public void cancel() {
        checkNotCancelled();
        this.cancelled = true;
    }

    // 用座位號碼找座位（不分大小寫），找不到回傳 null
    public Seat findSeat(String seatNo) {
        if (seatNo == null) return null;
        for (Seat seat : seats) {
            if (seat.getSeatNo().equalsIgnoreCase(seatNo.trim())) {
                return seat;
            }
        }
        return null;
    }

    // 剩餘空位數
    public int getAvailableSeatCount() {
        int count = 0;
        for (Seat seat : seats) {
            if (seat.isAvailable()) count++;
        }
        return count;
    }

    private void checkNotCancelled() {
        if (cancelled) {
            throw new IllegalStateException("航班 " + flightNo + " 已取消");
        }
    }

    // 印出航班資訊
    @Override
    public String toString() {
        return String.format("%s %s → %s | 起飛 %s | 登機門 %s | 空位 %d/%d%s",
                flightNo, origin, destination,
                departureTime.format(TIME_FORMAT), gate,
                getAvailableSeatCount(), seats.size(),
                cancelled ? " | 【已取消】" : "");
    }
}
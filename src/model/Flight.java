package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 負責：C
// Flight 和 Seat 是組合關係：座位隨航班建立
public class Flight {
    private String flightNo;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private String gate;
    private List<Seat> seats = new ArrayList<>();

    public Flight(String flightNo, String origin, String destination,
                  LocalDateTime departureTime, String gate) {
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.gate = gate;
        // TODO: 在這裡建立座位，例如 1–2 排 BUSINESS、3–20 排 ECONOMY
    }

    public String getFlightNo() { return flightNo; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public String getGate() { return gate; }
    public List<Seat> getSeats() { return seats; }

    // TODO: 回傳尚未被佔用的座位
    public List<Seat> getAvailableSeats() {
        return new ArrayList<>();
    }
}

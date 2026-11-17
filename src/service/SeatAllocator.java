package service;

import model.Booking;
import model.Seat;

// 負責：D
// 多型重點：不同的配位方式實作同一個介面
public interface SeatAllocator {
    Seat assignSeat(Booking booking);
}

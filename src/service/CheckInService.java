package service;

import model.BoardingPass;
import model.Booking;

// 負責：D
public interface CheckInService {
    // 報到成功回傳登機證
    BoardingPass checkIn(Booking booking, SeatAllocator allocator);
}

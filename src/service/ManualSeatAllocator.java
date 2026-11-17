package service;

import model.Booking;
import model.Seat;

// 負責：D
public class ManualSeatAllocator implements SeatAllocator {
    private String preferredSeatNo;

    public ManualSeatAllocator(String preferredSeatNo) {
        this.preferredSeatNo = preferredSeatNo;
    }

    @Override
    public Seat assignSeat(Booking booking) {
        // TODO: 找出旅客指定的座位，檢查艙等是否符合、是否已被佔用
        return null;
    }
}

package service;

import model.Booking;
import model.Seat;

// 負責：D
public class AutoSeatAllocator implements SeatAllocator {

    @Override
    public Seat assignSeat(Booking booking) {
        // TODO: 找出符合艙等的第一個空位，佔用後回傳；沒有空位要處理
        return null;
    }
}

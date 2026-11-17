package service;

import model.BoardingPass;
import model.Booking;

// 負責：D
public class CounterCheckInService implements CheckInService {

    @Override
    public BoardingPass checkIn(Booking booking, SeatAllocator allocator) {
        // TODO:
        // 1. 檢查旅客狀態是否為 BOOKED（避免重複報到）
        // 2. 檢查是否在報到時間內（例如起飛前 45 分鐘截止）
        // 3. 用 allocator 分配座位
        // 4. 產生 BoardingPass
        // 5. 把旅客狀態改成 CHECKED_IN
        return null;
    }
}

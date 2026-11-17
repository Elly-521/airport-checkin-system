package service;

import model.Baggage;
import model.BoardingPass;
import model.Booking;

// 負責：成員5（報到與行李）
// 櫃台報到：起飛前 45 分鐘截止，可以託運行李
public class CounterCheckInService implements CheckInService {

    @Override
    public BoardingPass checkIn(Booking booking, String seatNo) throws CheckInException {
        // TODO:
        // 1. 檢查訂位是否被取消、航班是否被取消
        // 2. 檢查是否在報到時間內（起飛前 getCloseMinutes() 分鐘截止）
        // 3. 找到座位，檢查是否存在、是否空位、艙等是否符合
        // 4. 佔用座位，存到 booking
        // 5. 旅客狀態改成 CHECKED_IN
        // 6. 產生並回傳 BoardingPass
        return null;
    }

    @Override
    public int addBaggage(Booking booking, Baggage baggage) throws CheckInException {
        // TODO:
        // 1. 必須先報到完成才能託運
        // 2.（加強）單件超過 32kg 拒收
        // 3. 總重超過座位的免費額度（seat.getFreeBaggageKg()）要收超重費
        return 0;
    }

    @Override
    public int getCloseMinutes() { return 45; }

    @Override
    public String getName() { return "櫃台報到"; }
}

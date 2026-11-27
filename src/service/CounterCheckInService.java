package service;

import java.time.LocalDateTime;

import model.Baggage;
import model.BoardingPass;
import model.Booking;
import model.Seat;


// 負責：成員5（報到與行李）
// 櫃台報到：起飛前 45 分鐘截止，可以託運行李
public class CounterCheckInService implements CheckInService {

    @Override
    public BoardingPass checkIn(Booking booking, String seatNo)
        throws CheckInException {

    // 1. 檢查訂位是否取消、航班是否取消
    if (booking == null || booking.isCancelled()) {
        throw new CheckInException("訂位已取消或不存在");
    }

    if (booking.getFlight().isCancelled()) {
        throw new CheckInException("航班已取消");
    }

    // 2. 檢查報到時間
    LocalDateTime deadline = booking.getFlight()
            .getDepartureTime().minusMinutes(getCloseMinutes());

    if (!LocalDateTime.now().isBefore(deadline)) {
        throw new CheckInException("已超過報到時間");
    }

    // 3. 找到座位，檢查是否存在、是否空位、艙等是否符合
    /*Seat seat = booking.getFlight().findSeat(seatNo);

    if (seat == null) {
        throw new CheckInException("找不到此座位");
    }

    if (!seat.isAvailable()) {
        throw new CheckInException("此座位已被佔用");
    }

    if (seat.getSeatClass() != booking.getSeatClass()) {
        throw new CheckInException("座位艙等不符合");
    }

    // 4. 佔用座位，存到 booking
    seat.occupy();
    booking.setSeat(seat);*/

    // 5. 旅客狀態改成 CHECKED_IN
    try {
        booking.getPassenger().checkIn();
    } catch (IllegalStateException e) {
        throw new CheckInException("旅客目前無法報到");
    }

    // 6. 產生並回傳登機證
    String passNo = "BP-" + booking.getBookingRef();

    return new BoardingPass(passNo, booking);
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

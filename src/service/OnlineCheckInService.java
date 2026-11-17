package service;

import model.Baggage;
import model.BoardingPass;
import model.Booking;

// 負責：成員5（報到與行李）
// 線上報到：起飛前 60 分鐘截止，不能託運行李
public class OnlineCheckInService implements CheckInService {

    @Override
    public BoardingPass checkIn(Booking booking, String seatNo) throws CheckInException {
        // TODO: 流程和櫃台報到一樣，只是截止時間不同
        //（提示：可以考慮把共同的檢查寫成 private 方法，或另外抽成共用類別）
        return null;
    }

    @Override
    public int addBaggage(Booking booking, Baggage baggage) throws CheckInException {
        throw new CheckInException("線上報到無法託運行李，請至櫃台辦理");
    }

    @Override
    public int getCloseMinutes() { return 60; }

    @Override
    public String getName() { return "線上報到"; }
}

package service;

import model.Baggage;
import model.BoardingPass;
import model.Booking;

// 負責：成員5（報到與行李）
// 介面：櫃台報到和線上報到都實作它（介面＋多型展示重點）
// AirportSystem 只依賴這個介面，不需要知道是哪一種報到方式
public interface CheckInService {

    // 報到成功回傳登機證，失敗丟出 CheckInException
    BoardingPass checkIn(Booking booking, String seatNo) throws CheckInException;

    // 託運行李，回傳要付的超重費
    int addBaggage(Booking booking, Baggage baggage) throws CheckInException;

    // 報到截止：起飛前幾分鐘
    int getCloseMinutes();

    // 報到方式名稱，例如「櫃台報到」
    String getName();
}

package service;

import model.BoardingPass;
import model.Booking;
import model.Passenger;
import model.PassengerStatus;

import java.util.ArrayList;
import java.util.List;


// 負責：成員6（登機證與登機）
public class BoardingService {

    // 登機截止：起飛前幾分鐘
    public static final int BOARDING_CLOSE_MINUTES = 15;

    // 登機成功回傳 true
    public boolean board(BoardingPass pass) {
        if (pass == null) {
            return false;
        }
        Passenger passenger = pass.getBooking().getPassenger();

        // 1. 必須是 CHECKED_IN 才能登機
        if (passenger.getStatus() != PassengerStatus.CHECKED_IN) {
            System.out.println("登機失敗：" + passenger.getName()
                    + " 目前狀態為 " + passenger.getStatus() + "，需先完成報到");
            return false;
        }

        // 2. 旅客狀態改成 BOARDED（由成員3的 Passenger.board() 負責）
        passenger.board();
        System.out.println("登機成功：" + passenger.getName());
        return true;
    }

    // TODO: 依登機順序排序（例如商務艙優先）
    // 登機順序：商務艙優先，同艙等維持原本順序
    public List<BoardingPass> getBoardingOrder(List<BoardingPass> passes) {
        List<BoardingPass> sorted = new ArrayList<>(passes);
        sorted.sort((a, b) -> b.getBooking().getSeatClass().ordinal()
                            - a.getBooking().getSeatClass().ordinal());
        return sorted;
    }

    // TODO（加強）：列出已報到但還沒登機的旅客
    // （加強）已報到但還沒登機的旅客
    public List<Booking> getNotBoardedList(List<Booking> bookings) {
        List<Booking> result = new ArrayList<>();
        for (Booking b : bookings) {
            if (!b.isCancelled()
                    && b.getPassenger().getStatus() == PassengerStatus.CHECKED_IN) {
                result.add(b);
            }
        }
        return result;
    }
}

package service;

import model.BoardingPass;
import model.Booking;

import java.util.ArrayList;
import java.util.List;

// 負責：成員6（登機證與登機）
public class BoardingService {

    // 登機截止：起飛前幾分鐘
    public static final int BOARDING_CLOSE_MINUTES = 15;

    // 登機成功回傳 true
    public boolean board(BoardingPass pass) {
        // TODO:
        // 1. 檢查旅客狀態是否為 CHECKED_IN，不是就拒絕
        // 2.（加強）檢查是否超過登機截止時間
        // 3. 旅客狀態改成 BOARDED
        return false;
    }

    // TODO: 依登機順序排序（例如商務艙優先）
    public List<BoardingPass> getBoardingOrder(List<BoardingPass> passes) {
        return new ArrayList<>(passes);
    }

    // TODO（加強）：列出已報到但還沒登機的旅客
    public List<Booking> getNotBoardedList(List<Booking> bookings) {
        return new ArrayList<>();
    }
}

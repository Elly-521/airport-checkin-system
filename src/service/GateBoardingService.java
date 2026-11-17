package service;

import model.BoardingPass;

// 負責：E
public class GateBoardingService implements BoardingService {

    @Override
    public boolean board(BoardingPass pass) {
        // TODO:
        // 1. 檢查旅客狀態是否為 CHECKED_IN，不是就拒絕登機
        // 2. 把狀態改成 BOARDED
        return false;
    }
}

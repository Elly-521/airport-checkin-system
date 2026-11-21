package model;

// 負責：成員6（登機證與登機）
import model.Booking;
import model.BoardingPass;

// 負責：成員6（登機證與登機）
public class BoardingService {
    private int passCounter = 1;

    // 基本版：檢查訂位狀態 → 旅客登機 → 產生並印出登機證
    public BoardingPass board(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("訂位資料不存在");
        }
        if (booking.isCancelled()) {
            throw new IllegalStateException("訂位已取消，無法登機");
        }
        if (booking.getFlight().isCancelled()) {
            throw new IllegalStateException("航班已取消，無法登機");
        }
        if (booking.getSeat() == null) {
            throw new IllegalStateException("尚未分配座位，無法登機");
        }

        // 狀態檢查由成員3的 Passenger.board() 負責（非 CHECKED_IN 會丟例外）
        booking.getPassenger().board();

        BoardingPass pass = new BoardingPass(String.format("BP%03d", passCounter++), booking);
        pass.print();
        return pass;
    }
}

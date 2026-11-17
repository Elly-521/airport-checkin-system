import model.*;
import service.*;

import java.time.LocalDateTime;

// 負責：E
// 示範完整流程：建立航班與旅客 → 報到 → 選位 → 登機證 → 登機
public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight("BR123", "TPE", "NRT",
                LocalDateTime.now().plusHours(2), "B5");

        Passenger alice = new Passenger("P001", "Alice Wang", "312345678");
        Booking booking = new Booking("ABC123", alice, flight, SeatClass.ECONOMY);

        System.out.println(alice.getName() + " 狀態：" + alice.getStatus());

        // TODO: 呼叫 CounterCheckInService 報到、GateBoardingService 登機
        // TODO: 示範錯誤情況：未報到就登機、重複報到、座位已被選走
    }
}

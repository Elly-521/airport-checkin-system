import model.*;
import service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 負責：成員1（組長／系統整合）Elly
// 主程式：主選單整合各模組
public class AirportSystem {
    private List<Flight> flights = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    // 介面型別：執行時決定用哪一種報到方式（多型）
    private CheckInService counterCheckIn = new CounterCheckInService();
    private CheckInService onlineCheckIn = new OnlineCheckInService();
    private BoardingService boardingService = new BoardingService();

    public static void main(String[] args) {
        AirportSystem system = new AirportSystem();
        system.loadSampleData();
        system.run();
    }

    // 建立測試資料
    private void loadSampleData() {
        Flight flight = new Flight("BR123", "TPE", "NRT",
                LocalDateTime.now().plusHours(2), "B5");
        flight.addSeat(new BusinessSeat("1A"));
        flight.addSeat(new BusinessSeat("1B"));
        flight.addSeat(new EconomySeat("10A"));
        flight.addSeat(new EconomySeat("10B"));
        flights.add(flight);

        Passenger alice = new Passenger("P001", "Alice Wang", "312345678");
        bookings.add(new Booking("ABC123", alice, flight, SeatClass.ECONOMY));
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== 機場報到與登機系統 =====");
            System.out.println("1. 查詢航班");
            System.out.println("2. 櫃台報到");
            System.out.println("3. 線上報到");
            System.out.println("4. 登機");
            System.out.println("5. 報到統計報表");
            System.out.println("0. 離開");
            System.out.print("請選擇：");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": showFlights(); break;
                case "2": doCheckIn(counterCheckIn); break;
                case "3": doCheckIn(onlineCheckIn); break;
                case "4": System.out.println("TODO：登機"); break;
                case "5": System.out.println("TODO：統計報表"); break;
                case "0": System.out.println("再見！"); return;
                default:  System.out.println("請輸入 0～5");
            }
        }
    }

    private void showFlights() {
        for (Flight f : flights) {
            System.out.println(f + "  登機門 " + f.getGate() + "  座位 " + f.getSeats());
        }
    }

    // 同一個方法可以處理兩種報到方式：傳進來的是哪個物件，就用哪個的規則
    private void doCheckIn(CheckInService service) {
        System.out.println("【" + service.getName() + "】起飛前 "
                + service.getCloseMinutes() + " 分鐘截止");
        // TODO: 輸入訂位代號和座位，呼叫 service.checkIn()，並用 try-catch 處理 CheckInException
    }

    // TODO（加強）：航班報到統計報表（未報到／已報到／已登機人數）
}

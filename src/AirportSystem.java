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
            System.out.println("\n===== Airport Check-in & Boarding System =====");
            System.out.println("1. View flights");
            System.out.println("2. Counter check-in");
            System.out.println("3. Online check-in");
            System.out.println("4. Boarding");
            System.out.println("5. Check-in report");
            System.out.println("0. Exit");
            System.out.print("Please choose: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1": showFlights(); break;
                case "2": doCheckIn(counterCheckIn); break;
                case "3": doCheckIn(onlineCheckIn); break;
                case "4": System.out.println("TODO: Boarding"); break;
                case "5": System.out.println("TODO: Report"); break;
                case "0": System.out.println("Goodbye!"); return;
                default:  System.out.println("Please enter 0-5");
            }
        }
    }

    private void showFlights() {
        for (Flight f : flights) {
            System.out.println(f + "\n   Seats: " + f.getSeats());
        }
    }

    // 同一個方法可以處理兩種報到方式：傳進來的是哪個物件，就用哪個的規則
    private void doCheckIn(CheckInService service) {
        System.out.println("[" + service.getName() + "] Closes "
                + service.getCloseMinutes() + " minutes before departure");
        // TODO: 輸入訂位代號和座位，呼叫 service.checkIn()，並用 try-catch 處理 CheckInException
    }

    // TODO（加強）：航班報到統計報表（未報到／已報到／已登機人數）
}
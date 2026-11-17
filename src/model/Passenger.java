package model;

// 負責：C
public class Passenger extends Person {
    private String passportNo;
    private PassengerStatus status = PassengerStatus.BOOKED;

    public Passenger(String id, String name, String passportNo) {
        super(id, name);
        this.passportNo = passportNo;
    }

    public String getPassportNo() { return passportNo; }
    public PassengerStatus getStatus() { return status; }

    // TODO: 封裝重點：檢查狀態轉換是否合法（只能 BOOKED→CHECKED_IN→BOARDED）
    public void setStatus(PassengerStatus status) {
        this.status = status;
    }

    @Override
    public String getRole() { return "Passenger"; }
}

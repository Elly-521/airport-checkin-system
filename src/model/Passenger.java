package model;

// 負責：成員3（旅客與訂位）
public class Passenger {
    private String id;
    private String name;
    private String passportNo;
    private PassengerStatus status = PassengerStatus.BOOKED;

    public Passenger(String id, String name, String passportNo) {
        this.id = id;
        this.name = name;
        this.passportNo = passportNo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPassportNo() { return passportNo; }
    public PassengerStatus getStatus() { return status; }

    // TODO: 只有 BOOKED 才能改成 CHECKED_IN，否則丟出 IllegalStateException
    public void checkIn() {
    }

    // TODO: 只有 CHECKED_IN 才能改成 BOARDED，否則丟出 IllegalStateException
    public void board() {
    }
}

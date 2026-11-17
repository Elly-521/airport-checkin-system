package model;

// 負責：C
// 抽象類別：Passenger 和 Staff 的共同父類別
public abstract class Person {
    private String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    // TODO: 子類別各自實作，例如回傳 "Passenger" 或 "Staff"
    public abstract String getRole();
}

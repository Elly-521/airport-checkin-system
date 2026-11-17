package model;

// 負責：C
public class Staff extends Person {
    private String role; // 例如 "Counter"、"Gate"

    public Staff(String id, String name, String role) {
        super(id, name);
        this.role = role;
    }

    @Override
    public String getRole() { return role; }
}

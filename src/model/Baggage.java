package model;

// 負責：成員5（報到與行李）
// 實作 Printable：印出行李條（和 BoardingPass 實作同一個介面）
public class Baggage implements Printable {
    private String tagNo;
    private double weightKg;

    public Baggage(String tagNo, double weightKg) {
        this.tagNo = tagNo;
        this.weightKg = weightKg;
    }

    public String getTagNo() { return tagNo; }
    public double getWeightKg() { return weightKg; }

    @Override
    public void print() {
        // TODO: 印出行李條（行李編號、重量）
    }
}

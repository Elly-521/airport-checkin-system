package model;

// 負責：成員5（報到與行李）
public class Baggage implements Printable {
    private String tagNo;
    private double weightKg;

    public Baggage(String tagNo, double weightKg) {
        this.tagNo = tagNo;
        this.weightKg = weightKg;
    }

    public String getTagNo() {
        return tagNo;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public void print() {
        System.out.println("========== 行李條 ==========");
        System.out.println("行李編號：" + tagNo);
        System.out.printf("行李重量：%.1f kg%n", weightKg);
        System.out.println("============================");
    }
}

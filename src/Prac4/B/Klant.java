package Prac4.B;

public class Klant {
    private String naam;
    private double kortingPercentage;

    public Klant(String nm) {
        this.naam = nm;
    }

    public void setKorting(double kP) {
        this.kortingPercentage = kP;
    }

    public double getKorting() {
        return this.kortingPercentage;
    }

    @Override
    public String toString() {
        return "op naam van: " + this.naam + "(korting: " + this.kortingPercentage + "%)";
    }
}

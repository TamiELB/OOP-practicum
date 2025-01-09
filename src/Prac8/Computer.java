package Prac8;

public class Computer implements Goed {
    private String type;
    private String macAdres;
    private double aanschafPrijs;
    private int productieJaar;

    public Computer(String tp, String adr, double pr, int jr) {
        this.type = tp;
        this.macAdres = adr;
        this.aanschafPrijs = pr;
        this.productieJaar = jr;
    }

    @Override
    public double huidigeWaarde(){
        int aantalJaren = java.time.Year.now().getValue() - this.productieJaar;
        double huidigeWaarde = this.aanschafPrijs;
        double kortingPerJaar = 40;

        // Verminder de waarde met 40% per jaar
        for (int i = 0; i < aantalJaren; i++) {
            huidigeWaarde *= (100 - kortingPerJaar) / 100;
        }
        return huidigeWaarde;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Computer computer))
            return false;

        return this.type.equals(computer.type)
                && this.macAdres.equals(computer.macAdres)
                && this.aanschafPrijs == computer.aanschafPrijs
                && this.productieJaar == computer.productieJaar;
    }

    @Override
    public String toString() {
        return "Computer: " + this.type + " met mac adres: " + this.macAdres + " met productie: " + this.productieJaar + " heeft een waarde van: " + String.format("%.2f", this.huidigeWaarde());
    }
}

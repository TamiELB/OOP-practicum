package Prac8;

public class Auto extends Voertuig{
    private String kenteken;

    public Auto(String tp, double pr, int jr, String kt){
        super(tp, pr, jr);
        this.kenteken = kt;
    }

    @Override
    public double huidigeWaarde(){
        int aantalJaren = java.time.Year.now().getValue() - this.bouwjaar;
        double huidigeWaarde = this.nieuwprijs;
        double kortingPerJaar = 30;

        // Verminder de waarde met 30% per jaar
        for (int i = 0; i < aantalJaren; i++) {
            huidigeWaarde *= (100 - kortingPerJaar) / 100;
        }

        return huidigeWaarde;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Auto auto))
            return false;

        if (!super.equals(obj))
            return false;

        return this.kenteken.equals(auto.kenteken);
    }
}

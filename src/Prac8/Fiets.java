package Prac8;

public class Fiets extends Voertuig{
    private int framenummer;

    public Fiets(String tp, double pr, int jr, int fnr){
        super(tp, pr, jr);
        this.framenummer = fnr;
    }

    @Override
    public double huidigeWaarde(){
        int aantalJaren = java.time.Year.now().getValue() - this.bouwjaar;
        double huidigeWaarde = this.nieuwprijs;
        double kortingPerJaar = 10;

        // Verminder de waarde met 10% per jaar
        for (int i = 0; i < aantalJaren; i++) {
            huidigeWaarde *= (100 - kortingPerJaar) / 100;
        }

        return huidigeWaarde;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fiets fiets))
            return false;

        if (!super.equals(obj))
            return false;

        return this.framenummer == fiets.framenummer;
    }
}

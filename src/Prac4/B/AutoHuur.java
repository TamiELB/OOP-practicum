package Prac4.B;

public class AutoHuur {
    private int aantalDagen;
    private Auto gehuurdeAuto;
    private Klant huurder;

    public AutoHuur() {

    }

    public void setAantalDagen(int aD) {
        this.aantalDagen = aD;
    }

    public int getAantalDagen() {
        return this.aantalDagen;
    }

    public void setGehuurdeAuto(Auto gA) {
        this.gehuurdeAuto = gA;
    }

    public Auto getGehuurdeAuto() {
        return this.gehuurdeAuto;
    }

    public void setHuurder(Klant k) {
        this.huurder = k;
    }

    public Klant getHuurder() {
        return this.huurder;
    }

    public double totaalPrijs(){
        if (this.gehuurdeAuto == null)
            return 0;

        double normalePrijs = this.gehuurdeAuto.getPrijsPerDag() * getAantalDagen();

        if (this.huurder == null)
            return normalePrijs;

        return normalePrijs * (1 - this.huurder.getKorting() / 100);
    }

    @Override
    public String toString() {
        String message = "";

        if (this.gehuurdeAuto == null)
            message += "Er is geen auto bekend";
        else
            message += this.gehuurdeAuto;

        message += "\n";

        if (this.huurder == null)
            message += "Er is geen klant bekend";
        else
            message += this.huurder;

        message += "\n";

        message += "Aantal dagen: " + this.aantalDagen + " en dat kost " + totaalPrijs();

        return message;
    }
}

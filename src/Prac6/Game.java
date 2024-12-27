package Prac6;

import java.time.Year;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return this.naam;
    }

    public double huidigeWaarde(){
        int aantalJaarUit = Year.now().getValue() - this.releaseJaar;

        if (aantalJaarUit <= 0) {
            return this.nieuwprijs;
        }

        double kortingPerJaar = 30;
        double korting = 1 - (kortingPerJaar / 100);
        // Korting^aantalJaarUit
        return this.nieuwprijs * Math.pow(korting, aantalJaarUit);
    }

    public boolean equals(Object andereObject){
        if (this.getClass() != andereObject.getClass())
            return false;

        Game game = (Game) andereObject;

        return this.naam.equals(game.naam) && this.releaseJaar == game.releaseJaar;
    }

    @Override
    public String toString() {
        return this.naam + ", uitgegeven in " + this.releaseJaar + "; nieuwprijs: €" +
                String.format("%.2f", this.nieuwprijs).replace(".", ",") + " nu voor: €" +
                String.format("%.2f", this.huidigeWaarde()).replace(".", ",");
    }
}

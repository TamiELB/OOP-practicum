package Prac8;

import java.util.ArrayList;

public class BedrijfsInventaris {
    private String bedrijfsnaam;
    private double budget;

    private ArrayList<Goed> alleGoederen = new ArrayList<>();

    public BedrijfsInventaris(String nm, double bud) {
        this.bedrijfsnaam = nm;
        this.budget = bud;
    }

    public void schafAan(Goed g){
        if (this.alleGoederen.stream().anyMatch(goed -> goed.equals(g)))
            return;

        if (this.budget < g.huidigeWaarde())
            return;

        this.budget -= g.huidigeWaarde();
        this.alleGoederen.add(g);
    }

    @Override
    public String toString() {
       String bericht = "";

       for (Goed g : this.alleGoederen) {
           bericht+= g.toString() + "\n";
       }

       return bericht;
    }
}

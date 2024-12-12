package Prac6;

import java.util.ArrayList;
import java.util.Optional;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g){
        if (this.mijnGames.stream()
                .anyMatch(mijnGame -> mijnGame.equals(g))) {
            return false;
        }

        double gamePrijs = g.huidigeWaarde();

        if (gamePrijs > this.budget)
            return false;

        this.budget -= gamePrijs;
        this.mijnGames.add(g);

        return true;
    }

    public boolean verkoop(Game g, Persoon koper){
        if (!this.mijnGames.contains(g))
            return false;

        double gamePrijs = g.huidigeWaarde();

        if (koper.getBudget() < gamePrijs)
            return false;

        if (!koper.koop(g))
            return false;

        this.mijnGames.remove(g);
        this.budget += gamePrijs;

        return true;
    }

    public Game zoekGameOpNaam(String gameNaam) {
        return mijnGames.stream()
                .filter(mijnGame -> mijnGame.getNaam().equals(gameNaam))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        String bericht = this.naam + " heeft een budget van €" +
                String.format("%.2f", this.budget).replace(".", ",")  +
                " en bezit de volgende games:";

        for (Game g : this.mijnGames)
            bericht += "\n" + g.toString();

        return bericht;
    }
}

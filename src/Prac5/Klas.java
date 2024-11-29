package Prac5;

import java.util.ArrayList;

public class Klas {
    private String klasCode;
    private ArrayList<Leerling> deLeerlingen = new ArrayList<>();

    public Klas(String klasCode) {
        this.klasCode = klasCode;
    }

    public void voegLeerlingToe(Leerling leerling) {
        this.deLeerlingen.add(leerling);
    }

    public void wijzigCijfer(String nm, double nweCijfer){
        this.deLeerlingen
                .stream()
                .filter(leerling -> leerling.getNaam().equals(nm))
                .findFirst()
                .ifPresent(leerling -> leerling.setCijfer(nweCijfer));
    }

    public ArrayList<Leerling> getLeerlingen(){
        return this.deLeerlingen;
    }

    public int aantalLeerlingen(){
        return this.deLeerlingen.size();
    }

    @Override
    public String toString() {
        String message = "In klas " + this.klasCode + " zitten de volgende leerlingen";

        for (Leerling leerling : this.deLeerlingen) {
            message += "\n" + leerling;
        }

        return message;
    }
}

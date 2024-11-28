package Prac2.B;

public class Main {
    public static void main(String[] args) {
        Voetbalclub aja = new Voetbalclub("Ajax     ");
        Voetbalclub fey = new Voetbalclub("Feyenoord");

        fey.verwerkResultaat('w');
        fey.verwerkResultaat('w');
        fey.verwerkResultaat('w');
        fey.verwerkResultaat('g');

        System.out.println("Feijenoord punten: " + fey.aantalPunten());
        System.out.println("Ajax gespeeld: " + aja.aantalGespeeld());
        System.out.println();

        System.out.println(aja);
        System.out.println(fey);
    }
}
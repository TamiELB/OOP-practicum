package Prac2.B;

public class Voetbalclub {
    private String naam;
    private int aantalGewonnen;
    private int aantalGelijk;
    private int aantalVerloren;

    public Voetbalclub(String naam) {
        this.naam = (naam == null || naam.trim().isEmpty()) ? "FC" : naam;
        this.aantalGewonnen = 0;
        this.aantalGelijk = 0;
        this.aantalVerloren = 0;
    }

    public String getNaam(){
        return naam;
    }

    public void verwerkResultaat(char resultaat) {
        if (resultaat == 'w')
            aantalGewonnen = aantalGewonnen + 1;
        if (resultaat == 'g')
            aantalGelijk = aantalGelijk + 1;
        if (resultaat == 'v')
            aantalVerloren = aantalVerloren + 1;
    }

    public int aantalPunten() {
        return aantalGewonnen * 3 + aantalGelijk;
    }

    public int aantalGespeeld() {
        return aantalGewonnen + aantalGelijk + aantalVerloren;
    }

    public String toString() {
        return naam + " " + aantalGespeeld() + " " + aantalGewonnen + " " + aantalGelijk + " " + aantalVerloren + " " + aantalPunten();
    }
}

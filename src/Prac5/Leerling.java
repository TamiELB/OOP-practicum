package Prac5;

public class Leerling {
    private String naam;
    private double cijfer;

    public Leerling(String naam) {
        this.naam = naam;
    }

    public String getNaam(){
        return naam;
    }

    public double getCijfer(){
        return cijfer;
    }

    public void setCijfer(double cijfer){
        this.cijfer = cijfer;
    }

    @Override
    public String toString() {
        return this.naam + " heeft cijfer: " + this.cijfer;
    }
}
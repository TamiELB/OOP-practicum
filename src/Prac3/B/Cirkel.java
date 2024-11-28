package Prac3.B;

public class Cirkel {
    private int radius;
    private int xPositie;
    private int yPositie;

    public Cirkel(int radius, int xPositie, int yPositie) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius moet groter dan 0 zijn!");

        this.radius =  radius;
        this.xPositie = xPositie;
        this.yPositie = yPositie;
    }

    @Override
    public String toString() {
        return "cirkel ("+ this.xPositie +","+ this.yPositie +") met radius: 10";
    }


}

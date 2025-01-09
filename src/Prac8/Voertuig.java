package Prac8;

public abstract class Voertuig implements Goed {
    private String type;

    protected double nieuwprijs;
    protected int bouwjaar;

    public Voertuig(String tp, double pr, int jr) {
        this.type = tp;
        this.nieuwprijs = pr;
        this.bouwjaar = jr;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Voertuig voertuig))
            return false;

        return this.type.equals(voertuig.type)
                && this.bouwjaar == voertuig.bouwjaar
                && this.nieuwprijs ==voertuig.nieuwprijs;
    }

    @Override
    public String toString() {
        return "Voertuig: " + this.type + " met bouwjaar " + this.bouwjaar + " heeft een waarde van: " + String.format("%.2f", this.huidigeWaarde());
    }
}
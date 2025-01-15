package Prac9.a;

public class Util {
    public static String euroBedrag(double bedrag) {
        return "€" +  String.format("%.2f", bedrag).replace('.', ',');
    }

    public static String euroBedrag(double bedrag, int precisie) {
        String format = "%." + precisie + "f";
        return "€" + String.format(format, bedrag).replace('.', ',');
    }

}

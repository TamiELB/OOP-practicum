package Prac9.a;

public class Util {
    public static String euroBedrag(double bedrag) {
        return euroBedrag(bedrag, 2);
    }

    public static String euroBedrag(double bedrag, int precisie) {
        String format = "%." + precisie + "f";
        return String.format(format, bedrag).replace('.', ',');
    }

}

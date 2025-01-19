package Prac8;

public class Util {
    public static String euroBedrag(double bedrag) {
        return formatString(bedrag, 2);
    }

    public static String euroBedrag(double bedrag, int precisie) {
        return formatString(bedrag, precisie);
    }

    private static  String formatString(double bedrag, int precisie) {
        String format = "%." + precisie + "f";
        return String.format(format, bedrag).replace('.', ',');
    }

}

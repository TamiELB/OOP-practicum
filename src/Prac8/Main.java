package Prac8;

public class Main {
    public static void main(String[] args) {
        BedrijfsInventaris bedrijfsInventaris = new BedrijfsInventaris("SomeCompany", 40000);

        String computerNaam = "MSI";
        double computerPrijs = 1250;
        int computerProductieJaar = 2024;
        Computer computer1 = new Computer(computerNaam, "72:A4:BC:3E:91:55", computerPrijs, computerProductieJaar);
        Computer computer2 = new Computer(computerNaam, "72:A4:BC:3E:91:55", computerPrijs, computerProductieJaar);

        String autoNaam = "Mercedes-Benz A-klasse A 180";
        double autoPrijs = 29995.00;
        int autoBouwjaar = 2019;
        Auto auto1 = new Auto(autoNaam, autoPrijs, autoBouwjaar, "4-ZTV-94");
        Auto auto2 = new Auto(autoNaam, autoPrijs, autoBouwjaar, "4-ZTV-94");

        String fietsNaam = "GAZELLE Avignon C5";
        double fietsPrijs = 4399.00;
        int fietsBouwjaar = 2020;
        Fiets fiets1 = new Fiets(fietsNaam, fietsPrijs, fietsBouwjaar, 1234);
        Fiets fiets2 = new Fiets(fietsNaam, fietsPrijs, fietsBouwjaar, 1234);

        Computer computer3 = new Computer("HP", "D8:16:7A:2F:CD:82", 550, 2020);
        Auto auto3 = new Auto("Audi S3", 65000.00, 2024, "JSON-23-HP");
        Fiets fiets3 = new Fiets("Rivena Elite D7", 799, 2024, 1234);

        bedrijfsInventaris.schafAan(computer1);
        bedrijfsInventaris.schafAan(computer2);

        System.out.println(bedrijfsInventaris.toString());

        bedrijfsInventaris.schafAan(auto1);
        bedrijfsInventaris.schafAan(auto2);

        System.out.println(bedrijfsInventaris.toString());

        bedrijfsInventaris.schafAan(fiets1);
        bedrijfsInventaris.schafAan(fiets2);

        System.out.println(bedrijfsInventaris.toString());

        bedrijfsInventaris.schafAan(computer3);
        bedrijfsInventaris.schafAan(auto3); // Te weinig budget hiervoor, dus het moet niet voorkomen
        bedrijfsInventaris.schafAan(fiets3);

        System.out.println(bedrijfsInventaris.toString());

        int aantalJaren = java.time.Year.now().getValue() - computerProductieJaar;
        double computerKortingPerJaar = 40;
        for (int i = 0; i < aantalJaren; i++) {
            computerPrijs *= (100 - computerKortingPerJaar) / 100;
        }

        aantalJaren = java.time.Year.now().getValue() - autoBouwjaar;
        double autoKortingPerJaar = 30;
        for (int i = 0; i < aantalJaren; i++) {
            autoPrijs *= (100 - autoKortingPerJaar) / 100;
        }

        aantalJaren = java.time.Year.now().getValue() - fietsBouwjaar;
        double fietsKortingPerJaar = 10;
        for (int i = 0; i < aantalJaren; i++) {
            fietsPrijs *= (100 - fietsKortingPerJaar) / 100;
        }

        System.out.println(computerNaam + " moet prijs: " + String.format("%.2f", computerPrijs) + " hebben");
        System.out.println(autoNaam + " moet prijs: " + String.format("%.2f", autoPrijs) + " hebben");
        System.out.println(fietsNaam + " moet prijs: " + String.format("%.2f", fietsPrijs) + " hebben");

    }
}

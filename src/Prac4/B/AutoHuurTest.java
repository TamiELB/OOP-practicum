package Prac4.B;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoHuurTest {

    private AutoHuur autoHuur;
    private Auto gehuurdeAuto;
    private Klant huurder;

    @BeforeEach
    void setUp() {
        autoHuur = new AutoHuur();
        gehuurdeAuto = new Auto("Audi RS3", 120);  // Initialize gehuurdeAuto
        huurder = new Klant("Piet");  // Initialize huurder
    }

    @Test
    void test_GeenHuurderGeenAuto() {
        assertEquals(0, autoHuur.totaalPrijs(), "Totaal prijs moet 0 zijn zonder huurder en zonder auto");
        assertEquals("Er is geen auto bekend\nEr is geen klant bekend\nAantal dagen: 0 en dat kost 0.0", autoHuur.toString());
    }

    @Test
    void test_GeenHuurderWelAuto() {
        autoHuur.setGehuurdeAuto(gehuurdeAuto);
        autoHuur.setAantalDagen(3);
        assertEquals(360, autoHuur.totaalPrijs(), "Totaal prijs moet 360 zijn zonder huurder (120 * 3)");
        assertEquals("autotype: Audi RS3 met prijs per dag: 120.0\nEr is geen klant bekend\nAantal dagen: 3 en dat kost 360.0", autoHuur.toString());
    }

    @Test
    void test_WelHuurderGeenAuto() {
        autoHuur.setHuurder(huurder);
        autoHuur.setAantalDagen(5);
        assertEquals(0, autoHuur.totaalPrijs(), "Totaal prijs moet 0 zijn zonder gehuurde auto");
        assertEquals("Er is geen auto bekend\nop naam van: Piet(korting: 0.0%)\nAantal dagen: 5 en dat kost 0.0", autoHuur.toString());
    }

    @Test
    void test_WelHuurderGeenAutoMetKorting() {
        huurder.setKorting(20);
        autoHuur.setHuurder(huurder);
        autoHuur.setAantalDagen(5);
        assertEquals(0, autoHuur.totaalPrijs(), "Totaal prijs moet 0 zijn zonder gehuurde auto");
        assertEquals("Er is geen auto bekend\nop naam van: Piet(korting: 20.0%)\nAantal dagen: 5 en dat kost 0.0", autoHuur.toString());
    }

    @Test
    void test_WelHuurderWelAutoGeenKorting() {
        autoHuur.setHuurder(huurder);
        autoHuur.setGehuurdeAuto(gehuurdeAuto);
        autoHuur.setAantalDagen(2);
        assertEquals(240, autoHuur.totaalPrijs(), "Totaal prijs moet 240 zijn zonder korting (120 * 2)");
        assertEquals("autotype: Audi RS3 met prijs per dag: 120.0\nop naam van: Piet(korting: 0.0%)\nAantal dagen: 2 en dat kost 240.0", autoHuur.toString());
    }

    @Test
    void test_WelHuurderWelAutoMetKorting() {
        double kortingPercentage = 20;
        huurder.setKorting(kortingPercentage); // 20% korting
        autoHuur.setHuurder(huurder);
        autoHuur.setGehuurdeAuto(gehuurdeAuto);
        autoHuur.setAantalDagen(4);
        assertEquals(120 * 4 * (1 - kortingPercentage/ 100), autoHuur.totaalPrijs(), "Totaal prijs moet 384 zijn met korting (120 * 4 * 0.8)");
        assertEquals("autotype: Audi RS3 met prijs per dag: 120.0\nop naam van: Piet(korting: 20.0%)\nAantal dagen: 4 en dat kost 384.0", autoHuur.toString());
    }
}

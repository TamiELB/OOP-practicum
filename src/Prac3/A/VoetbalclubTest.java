package Prac3.A;

import Prac2.B.Voetbalclub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoetbalclubTest {

    @Test
    void legeClubNaam() {
        Voetbalclub fc = new Voetbalclub(null);
        assertSame("FC", fc.getNaam(), "Naam moet 'FC' zijn bij null input");

        Voetbalclub fc2 = new Voetbalclub(" ");
        assertEquals("FC", fc2.getNaam(), "Naam moet 'FC' zijn bij lege input");
    }

    @Test
    void testWinst() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('w');
        assertEquals(3, fc.aantalPunten(), "Punten na winst incorrect");
        assertEquals(1, fc.aantalGespeeld(), "Aantal gespeeld na winst incorrect");
        assertEquals("Test 1 1 0 0 3", fc.toString(), "toString incorrect na winst");
    }

    @Test
    void testGelijkspel() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('g');
        assertEquals(1, fc.aantalPunten(), "Punten na gelijkspel incorrect");
        assertEquals(1, fc.aantalGespeeld(), "Aantal gespeeld na gelijkspel incorrect");
        assertEquals("Test 1 0 1 0 1", fc.toString(), "toString incorrect na gelijkspel");
    }

    @Test
    void testVerlies() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('v');
        assertEquals(0, fc.aantalPunten(), "Punten na verlies incorrect");
        assertEquals(1, fc.aantalGespeeld(), "Aantal gespeeld na verlies incorrect");
        assertEquals("Test 1 0 0 1 0", fc.toString(), "toString incorrect na verlies");
    }

    @Test
    void testOngeldigeInvoer() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('x');
        assertEquals(0, fc.aantalPunten(), "Punten moeten ongewijzigd blijven bij ongeldige invoer");
        assertEquals(0, fc.aantalGespeeld(), "Aantal gespeeld moet ongewijzigd blijven bij ongeldige invoer");
        assertEquals("Test 0 0 0 0 0", fc.toString(), "toString incorrect bij ongeldige invoer");
    }

    @Test
    void testHerhaaldeResultaten() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('w');
        fc.verwerkResultaat('g');
        fc.verwerkResultaat('v');
        assertEquals(4, fc.aantalPunten(), "Punten incorrect bij herhaalde invoer");
        assertEquals(3, fc.aantalGespeeld(), "Aantal gespeeld incorrect bij herhaalde invoer");
        assertEquals("Test 3 1 1 1 4", fc.toString(), "toString incorrect bij herhaalde invoer");
    }
}

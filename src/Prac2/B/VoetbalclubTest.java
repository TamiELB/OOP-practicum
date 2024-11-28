package Prac2.B;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VoetbalclubTest {

    @Test
    void legeClubNaam() {
        Voetbalclub fc = new Voetbalclub(null);
        assertSame("FC", fc.getNaam(), "Voetbalclub naam is niet FC");

        Voetbalclub fc2 = new Voetbalclub(" ");
        assertEquals("FC", fc2.getNaam(), "Voetbalclub naam is niet FC");
    }

    @Test
    void testWinst() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('w');
        assertEquals(3, fc.aantalPunten());
        assertEquals(1, fc.aantalGespeeld());
        assertEquals("Test 1 1 0 0 3", fc.toString());
    }

    @Test
    void testGelijkspel() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('g');
        assertEquals(1, fc.aantalPunten());
        assertEquals(1, fc.aantalGespeeld());
        assertEquals("Test 1 0 1 0 1", fc.toString());
    }

    @Test
    void testVerlies() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('v');
        assertEquals(0, fc.aantalPunten());
        assertEquals(1, fc.aantalGespeeld());
        assertEquals("Test 1 0 0 1 0", fc.toString());
    }

    @Test
    void testOngeldigeInvoer() {
        Voetbalclub fc = new Voetbalclub("Test");
        fc.verwerkResultaat('x');
        assertEquals(0, fc.aantalPunten());
        assertEquals(0, fc.aantalGespeeld());
        assertEquals("Test 0 0 0 0 0", fc.toString());
    }
}
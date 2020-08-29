

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        assertEquals(true, false, "Implementer maks og denne testen");
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        assertEquals(true, false, "Implementer ombyttinger og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {

        int[] d = {6, 2, 4, 6, 9, 1, 4, 9, 10};
        int svar = Oblig1.antallUlikeUsortert(d);
        assertEquals(6,svar);
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {
        assertEquals(true, false, "Implementer flett og denne testen");
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }
}
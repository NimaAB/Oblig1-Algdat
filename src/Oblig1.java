
////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        // Kaster en avvik når tabellen er tomt
        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tomt!");
        }

        // Løper gjennom arrayet og finner den største verdi
        ombyttinger(a);
        int maks_verdi = a[0];

        for(int i = 1; i < a.length; i++){
            if(a[i] > maks_verdi){
                maks_verdi = a[i];
            }
        }
        return maks_verdi;
    }

    public static int ombyttinger(int[] a) {
        int antOmbytting = 0;
        for(int i = 0; i<a.length-1; ++i){
            if(a[i]>a[i+1]){
                //ombytting:
                int tempt = a[i+1];
                a[i+1] = a[i];
                a[i] = tempt;
                antOmbytting++;
            }
        }
        return antOmbytting;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                throw new IllegalStateException("Tabellen er usortert!");
            }
        }
        // Variabel som inneholder antall ulike elementer
        int antall_ulike = 0;

        // Teller hvor mange elementer er ulike
        for(int i = 0; i < a.length; i++){
            // Hvis duplikater finnes, hopp over dem
            while(i < a.length-1 && a[i] == a[i+1]){
                i++;
            }
            antall_ulike++;
        }

        return antall_ulike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1


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


        int antall_ulike = 0;
        for (int i = 0; i < a.length; i++) {
            int current_num = a[i];
            boolean talletFinnes = false;
            for (int j = 0; j < i; j++){
                if (current_num == a[j]) {
                    talletFinnes = true;
                    break;
                }
            }
            if (!talletFinnes) {
                antall_ulike++;
            }
        }
        return antall_ulike;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {


        int begin = 0;
        int end = a.length - 1;

        // Samler alle partall på høyre side og oddetall på venstre side
        for(int i = begin; i < end; i++){
            if(a[i] % 2 == 0) {
                int temp = a[i];
                a[i] = a[end];
                a[end] = temp;
                end--;
                i--;
            }
        }
        for (int n = a.length; n >= 0; n--) {
            for (int i = 0; i < a.length - 1; ++i) {
                if((a[i]%2==1 && a[i+1]%2 == 1)){
                    if (a[i] > a[i + 1]) {
                        //bytting:
                        int tempt = a[i + 1];
                        a[i + 1] = a[i];
                        a[i] = tempt;
                    }
                } else if(a[i]%2==0 && a[i+1]%2==0){
                    if (a[i] > a[i + 1]) {
                        //bytting:
                        int tempt = a[i + 1];
                        a[i + 1] = a[i];
                        a[i] = tempt;
                    }
                }
            }
        }
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        if(a.length != 0){
            int end = a.length-1;
            char tempt = a[end];
            for(int i = end; i > 0; i--){
                a[i] = a[i-1];
                if(i == 1){
                    a[0] = tempt;
                }
            }
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    static void leftRotate(char [] arr, int k) {
        int n = arr.length;
        int mod = k % n;

        for (int i = 0; i < n; ++i) {
            arr [i] = arr[(i + mod) % n];
        }
    }
    static void reverseArray (char [] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    static void rightRotate(char [] arr, int k) {
        int n = arr.length;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }

    public static void rotasjon(char[] a, int k) {
        if(a.length !=2){
            if(k>=0){
                rightRotate(a,k);
            }else{
                k *=-1;
                leftRotate(a,k);
            }
        }

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
        int n = a.length;
        if(n<3){
            throw new NoSuchElementException();
        }
        int mI = min(a[0],a[1]);
        int nmI = max(a[0],a[1]);
        int tmI=2;
        if(a[mI]>a[tmI]){
            tmI = mI;
            mI = 2;
        }
        if(a[nmI]>a[tmI]){
            int temp = tmI;
            tmI = nmI;
            nmI = temp;
        }
        int m = a[mI]; int nm = a[nmI]; int tm = a[tmI];

        for (int i = 3; i<n; ++i){
            int current = a[i];
            if(current<tm){
                if(current<nm){
                    if(current<m){
                        tmI = nmI;
                        tm = a[tmI];
                        nmI = mI;
                        nm = a[nmI];
                        mI = i;
                        m = a[mI];
                    }else{
                        tmI = nmI;
                        tm = a[tmI];
                        nmI = i;
                        nm = a[nmI];
                    }
                }else{
                    tmI = i;
                    tm = a[tmI];
                }
            }
        }
        return new int[] {mI,nmI,tmI};
    }
    //Hjelpe metoder
    static int max(int ... a){
        int max_index=0;
        for(int i = 1; i<a.length; ++i){
            if (a[max_index] < a[i]){
                max_index = i;
            }
        }
        return max_index;
    }
    static int min(int ... a){
        int min_index=0;
        for(int i = 1; i<a.length; ++i){
            if (a[min_index] > a[i]){
                min_index = i;
            }
        }
        return min_index;
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1

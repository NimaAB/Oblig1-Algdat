
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
        char [] S_arr = splitString(s);
        char [] T_arr = splitString(t);
        //Deklarer n slik:(hvis s>t så er den s) else if(s<t så er den t) else (den er t)
        int n = (S_arr.length> T_arr.length)? S_arr.length : (S_arr.length<T_arr.length)? T_arr.length : T_arr.length;

        char [] flettIChar = new char[S_arr.length + T_arr.length];
        int i = 0;
        while(i<n){
            if(i==0 && S_arr.length != 0 && T_arr.length!=0){
                flettIChar[i] = S_arr[i];
                flettIChar[i+1] = T_arr[i];
            }else if(i>= S_arr.length){
                int j = 2*i;
                int k = i;
                while(j<flettIChar.length){
                    flettIChar[j] = T_arr[k];
                    k++;
                    j++;
                }
                break;
            }else if(i>= T_arr.length){
                int j = 2*i;
                int k = i;
                while(j<flettIChar.length){
                    flettIChar[j] = S_arr[k];
                    k++;
                    j++;
                }
                break;
            } else{
                flettIChar[2*i] = S_arr[i];
                flettIChar[2*i+1] = T_arr[i];
            }
            i++;
        }

        StringBuilder flettet = new StringBuilder();
        for(char c:flettIChar){
            flettet.append(c);
        }
        return flettet.toString();
    }
    //hjelpemetode for 7a)
    static char[] splitString(String a){
        int n= a.length();
        char [] aSplit = new char[n];
        for(int i = 0; i<n;++i){
            aSplit[i] = a.charAt(i);
        }
        return aSplit;
    }


    /// 7b)
    public static String flett(String... s) {
        int ls = 0;
        for (String value : s) {
            if (value.length() > ls) {
                ls = value.length();
            }
        }
        char [][] data = new char[s.length][ls];
        for(int i =0; i<s.length;++i){
            for(int j = 0; j<s[i].length();++j){
                data[i][j]=s[i].charAt(j);
            }
        }

        String resultat ="";
        for(int i = 0; i<ls;++i){
            for(int j = 0; j<s.length;++j){
                if(data[j][i]!=0){
                    resultat+=data[j][i];
                }
            }
        }
        return resultat;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        int [] indekser = new int[a.length];
        int [] arr = a.clone();                         //Arrayet a kan ikke endre seg, derfor jeg brukte en arr

        // Sortert arr arrayet ved bruk av insertion sort
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;                              //Indeks til tallet bak
            while(j >= 0 && current < arr[j]) {         //Så lenge det finnes et tall mindre enn current, bytt plass
                arr[j+1] = arr[j];                      //Tallet bak blir verdien til indeks foran seg
                j--;                                    //Bryter while loopen
            }
            arr[j+1] = current;                         //Tallet foran blir verdien til indeks bak seg
        }

        // Sammenligner de to arrayet og lagrer deres indeks
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == a[j]){
                    indekser[i] = j;
                    break;
                }
            }
        }

        return indekser;
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
        String str = "";
        boolean inneholdt = true;

        // Hvis det finnes et tegn på String a som ikke finnes i String b, return false
        for(int i = 0; i < a.length(); i++){
            if(b.indexOf(a.charAt(i)) == -1){
                return false;
            }
        }

        // Finner hvilke tegner vi ser etter
        for(int i = 0; i < a.length(); i++) {
            if(str.indexOf(a.charAt(i)) == -1)
                str = str+a.charAt(i);
        }

        // Teller hvor mange tegn er på hvert string
        int[] counterA = counter(str,a);
        int[] counterB = counter(str,b);

        // Hvis antall tegn på String b er mindre enn antall tegn på String a, return false
        for(int ca : counterA){
            for(int cb : counterB){
                if (cb < ca) {
                    inneholdt = false;
                    break;
                }
            }
        }

        return inneholdt;
    }

    // Hjelpe metode for oppgave 10
    public static int[] counter(String a, String b){
        int[] result = new int[a.length()];
        int counter = 0;
        for(int i = 0; i < a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(a.charAt(i) == b.charAt(j)){
                    counter++;
                }
            }
            result[i] = counter;
            counter = 0;
        }
        return result;
    }

}  // Oblig1

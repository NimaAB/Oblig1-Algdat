public class Forarbeid {
    static void delsortering(int [] a){
        int [] a_delsortert;

        //separer i to array:
        int[] partall = {0};
        int[] oddetall = {0};
        for (int i = 0; i < a.length; ++i) {
            if (a[i] % 2 == 0) {
                    partall[i] = a[i];
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) {
                    oddetall[i] = a[i];
            }
        }

        //sorter dem:
        //int[] partallSortert = new int[partall.length];
        for (int n = partall.length; n >= 0; n--) {
            for (int i = 0; i < partall.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    //bytting:
                    int tempt = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = tempt;
                }
            }
        }

        //int[] oddetallSortert = new int[oddetall.length];
        for (int n = oddetall.length; n >= 0; n--) {
            for (int i = 0; i < oddetall.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    //bytting:
                    int tempt = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = tempt;
                }
            }
        }
        //legg sammen: O + P
        a_delsortert = new int[a.length];
        for (int i = 0; i < oddetall.length; ++i) {
            a_delsortert[i] = oddetall[i];
        }
        //The following loop gets a arrayOutOfBoundExeption:
        for (int i = a_delsortert.length; i < partall.length;++i) {
            a_delsortert[i] = partall[i];
        }
    }
}

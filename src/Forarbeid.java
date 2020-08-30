public class Forarbeid {

/*    static void rotasjon(char [] a, int k){

        int j = 0;
        while (j<k) {
            int end = a.length-1;
            char tempt = a[end];
            for(int i = end; i > 0; i--){
                a[i] = a[i-1];
                if(i == 1){
                    a[0] = tempt;
                }
            }
            j++;
        }
    }*/

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

    // Function to right rotate
    // arr[] of size n by d
    static void rightRotate(char [] arr, int k) {
        int n = arr.length;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
    }



    public static void main(String[] args) {
        char[] a= {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};;
       leftRotate(a,2);
       for(char el:a){
           System.out.println(el);
       }
    }

    /*int left = 0;
        int right = a.length-1;
        int antall_oddtall = 0;
        for(int i = 0; i < a.length; i++){
            while(a[left] % 2 == 1){
                left++;
                antall_oddtall++;
            }
            while(a[right] % 2 == 0){
                right--;
            }
            if(left > right){
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }*/

}

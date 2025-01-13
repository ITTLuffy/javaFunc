
import java.util.Arrays;


public class ripassoVerifica {
    public static void main(String[] args) throws Exception {

        // numeriSuccessivi(5);
        // System.out.println();
        // numeriPrecedenti(5);

        ritornaVettore(5);

    }

    /**
     * metodo che stampa i 10 numeri successivi a n
     * @param n numero inserito
     */
    // public static void numeriSuccessivi(int n) {
    //     for (int i = 1; i <= 10; i++) { // ciclo for
    //         System.out.print(n + i + " "); // aggiungiamo alla n i, arrivando fino a n+10
    //     }
    //     System.out.println();
    //     int k = n;
    //     while(k < n+10){
    //         System.out.print(k + " ");
    //         k++;
    //     }

    // }

    // public static void numeriPrecedenti(int n) {
    //     for (int i = 1; i <= 10; i++) { // ciclo for
    //         System.out.print((n - i) + " "); // aggiungiamo alla n i, arrivando fino a n+10
    //     }
    //     System.out.println();
    //     int k = n;
    //     while(k > n-10){
    //         System.out.print(k + " ");
    //         k--;
    //     }


    // }


    public static int [] ritornaVettore(int n) {
        int[]v = new int[10];
        for (int i = 0; i < v.length; i++) {
            n++;            
            v[i] = n;
        }
        System.out.println(Arrays.toString(v));
        return v;
    }


    
}










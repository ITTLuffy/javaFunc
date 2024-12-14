import java.util.Arrays;
import java.util.Scanner;

public class exercisesMethods {
    /*
    Creare un metodo che prenda come argomento un numero intero e stampi 
    a video i 10 numeri successivi (fai l’esercizio sia con ciclo for che con while).
    */
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Inserisci un numero");
            int n = in.nextInt();
            stampa(n);
            stampaContrario(n);
            int[] vettore = new int[10];
            stampaArray(vettore, n);
            System.out.println(Arrays.toString(vettore));
            in.close();

        }

    }

    public static void stampa(int n) {
        System.out.println("Numeri successivi");
        for (int i = n+1; i <= n+10; i++) {
            System.out.println(i);
        }
        int k = n;
        while (k < 10+n) {
            k++;
            System.out.println(k);
        }

    }

    public static void stampaContrario(int n) {
        System.out.println("Numeri precedenti");
        for (int i = n-1; i >= n-10; i--) {
            System.out.println(i);
        } 

        int k = n;
        while (k > n-10) {
            k--;
            System.out.println(k);
        }

    }

    public static void stampaArray(int[] v, int n) {
        int j = 0;
        for (int i = n+1; i <= n+10; i++) {
            System.out.println(i);
            v[j] = i;
            j++;
        }
        j = 0;
        int k = n;

        while (k < 10+n) {
            k++;
            System.out.println(k);
            v[j] = k;
            j++;
        }

    }

}
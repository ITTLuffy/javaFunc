
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exercisesMethods {

    /*
    Creare un metodo che prenda come argomento un numero intero e stampi 
    a video i 10 numeri successivi (fai l’esercizio sia con ciclo for che con while).
     */
    public static void main(String[] args) throws Exception {
        Random r = new Random();

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Inserisci un numero");
            int n = in.nextInt();
            stampa(n);
            stampaContrario(n);
            int[] vettore = new int[10];
            stampaArray(vettore, n);
            System.out.println(Arrays.toString(vettore));
            in.close();

            int[] numeri = new int[5];
            for (int i = 0; i < numeri.length; i++) {
                numeri[i] = r.nextInt(1, 5);
            }
            System.out.println(Arrays.toString(numeri));
            tornaArray(numeri);
            System.out.println(Arrays.toString(numeri));
        }

    }

    public static void stampa(int n) {
        System.out.println("Numeri successivi");
        for (int i = n + 1; i <= n + 10; i++) {
            System.out.println(i);
        }
        int k = n;
        while (k < 10 + n) {
            k++;
            System.out.println(k);
        }

    }

    public static void stampaContrario(int n) {
        System.out.println("Numeri precedenti");
        for (int i = n - 1; i >= n - 10; i--) {
            System.out.println(i);
        }

        int k = n;
        while (k > n - 10) {
            k--;
            System.out.println(k);
        }

    }

    public static void stampaArray(int[] v, int n) {
        int j = 0;
        for (int i = n + 1; i <= n + 10; i++) {
            System.out.println(i);
            v[j] = i;
            j++;
        }
        j = 0;
        int k = n;

        while (k < 10 + n) {
            k++;
            System.out.println(k);
            v[j] = k;
            j++;
        }

    }

    public static int[] tornaArray(int[] v) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                v[i] = 0;
            }

        }
        return v;
    }

}

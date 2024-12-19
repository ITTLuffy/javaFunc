
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
            stampa(n); // metodo per esercizio 1
            stampaContrario(n); // metodo per esercizio 2

            // metodo per esercizio 3
            int[] vettore = new int[10];
            stampaArray(vettore, n);
            System.out.println(Arrays.toString(vettore));
            in.close();

            
            // metodo per esercizio 4
            tabellina(n);

            System.out.println("\n");

            int[] numeri = new int[5];
            for (int i = 0; i < numeri.length; i++) {
                numeri[i] = r.nextInt(1, 5);
            }
            System.out.println(Arrays.toString(numeri));
            tornaArray(numeri);
            System.out.println(Arrays.toString(numeri));

            cercaArray(numeri, n);
            System.out.println(Arrays.toString(numeri));

            immagine();
        }

    }

    public static void stampa(int n) { // metodo per esercizio 1
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

    public static void stampaContrario(int n) { // metodo per esercizio 2
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

    public static void stampaArray(int[] v, int n) { // metodo per esercizio 3
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

    public static void tabellina(int n) { // metodo per esercizio 4
        System.out.println("Tabellina del " + n);
        for(int i = 0; i <= n*10; i++) {
            if (i % n == 0) {
                System.out.print(i);
                System.out.print(" ");
            }
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

    public static boolean cercaArray(int[] v, int n) {
        /*
        for (int i = 0; i < v.length; i++) {
            if (v[i] == n) {
                System.out.println("Numero trovato");
                return true;
            }
        }
        System.out.println("Numero non trovato");
        return false;
         */
        for (int i : v) {
            if (v[i] == n) {
                System.out.println("Numero trovato");
                return true;
            }
        }
        return false;
    }

    public static void immagine() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i;
            System.out.print(s);
            int zeri = (10 - i);
            while (zeri > 0) {
                System.out.print(0);
                zeri--;
            }
        }

    }

}

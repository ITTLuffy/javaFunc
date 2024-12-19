
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exercisesMethods {

    // dimensione array es. 9
    public static int dim = 0;

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

            // metodo per esercizio 4
            tabellina(n);

            System.out.println(" ");

            // metodo per esercizio 5
            System.out.println("Inserisci due numeri");
            minore(in.nextInt(), in.nextInt());

            // metodo per esercizio 6
            System.out.println("Inserisci due stringhe");
            uguale(in.next(), in.next());

            // metodo per esercizio 7
            int[] numeri = new int[5];
            for (int i = 0; i < numeri.length; i++) {
                numeri[i] = r.nextInt(1, 5);
            }
            System.out.println(Arrays.toString(numeri));
            tornaArray(numeri);
            System.out.println(Arrays.toString(numeri));

            // metodo per esercizio 8
            cercaArray(numeri, n);
            System.out.println(Arrays.toString(numeri));

            // metodo per esercizio 9
            int[] a = {0, 1, 2, 7, 4, 5};
            System.out.println(Arrays.toString(a));
            int[] b = filtra(a, n);
            System.out.println(Arrays.toString(b));

            // metodo per esercizio 10
            int[] bin = new int[8];
            binario(n, bin);
            System.out.println(Arrays.toString(bin));
            

            immagine();

            in.close();

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
        for (int i = 0; i <= n * 10; i++) {
            if (i % n == 0) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }

    public static void minore(int n1, int n2) { // metodo per esercizio 5
        if (n1 < n2) {
            System.out.println("Minore " + n1);
        } else {
            System.out.println("Minore " + n2);
        }
    }

    public static boolean uguale(String prima, String seconda) { // metodo per esercizio 6
        if (prima.equals(seconda)) {
            System.out.println("Uguali");
            return true;
        } else {
            return false;
        }
    }

    public static int[] tornaArray(int[] v) { // metodo per esercizio 7
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                v[i] = 0;
            }
        }
        return v;
    }

    public static boolean cercaArray(int[] v, int n) { // metodo per esercizio 8
        for (int i : v) {
            if (v[i] == n) {
                System.out.println("Numero trovato");
                return true;
            }
        }
        return false;
    }

    public static int[] filtra(int[] a, int k) { // metodo per esercizio 9
        // Conta il numero di elementi divisibili per k
        int c = 0;
        for (int i : a) {
            if (i % k == 0) {
                c++;
            }
        }

        // Crea un nuovo array con la dimensione uguale al numero di elementi contati
        int[] b = new int[c];
        int j = 0;
        for (int i : a) {
            if (i % k == 0) {
                b[j] = i;
            }
        }
        return b;
    }

    public static void stampaFormaVettore(int[] v) { // metodo 2 per esercizio 9 (UNIVERSALE)
        System.out.print("[");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("]");
    }

    public static int[] binario(int n, int[] v) { // metodo per esercizio 10
        int i = 7;
        while (n > 0) {
            v[i] = n % 2;
            n = n / 2;
            i--;
        }
        return v;
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

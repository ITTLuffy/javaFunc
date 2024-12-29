
import java.util.*;

public class pozioneEsplosiva {

    public static Scanner in = new Scanner(System.in);
    public static Random r = new Random();
    public static int dim = 0; // dimensione dinamica
    public static int dimMax = 0; // variabile per la dimensione massima del vettore

    public static void main(String[] args) {
        System.out.println("Inserisci la lunghezza del vettore con il quale vuoi giocare");
        dimMax = in.nextInt();

        int[] v = new int[dimMax];

        riempiVettore(v);
        stampaVettore(v);

        int mossaMigliore = mossaMigliore(v);
        System.out.println("Mossa migliore: " + mossaMigliore);
        System.out.println("Inserisci la posizione della sfera da togliere");
        togliSfera(v, in.nextInt());

        esplosione(v);

        int sfereRimosse = sfereRimosse(v);
        System.out.println("Sono state rimosse " + sfereRimosse + " sfere");

    }

    /**
     * Funzione per stampare il vettore
     *
     * @param v vettore da stampare
     */
    public static void stampaVettore(int[] v) {
        System.out.print("[");
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Funzione per riempire il vettore
     *
     * @param v vettore da riempire
     */
    public static void riempiVettore(int[] v) {
        // colori
        /*
        * rosso = 1
        * verde = 2
        * giallo = 3
        * blu = 4
         */
        for (int i = 0; i < v.length; i++) {
            v[dim] = r.nextInt(1, 5);
            dim++;
        }

    }

    /**
     * Funzione per togliere una sfera
     *
     * @param v vettore
     * @param pos posizione della sfera da togliere
     */
    public static void togliSfera(int[] v, int pos) {
        if (pos > 0 && pos < dimMax) {
            for (int i = pos; i < dim - 1; i++) {
                v[i] = v[i + 1];
            }
            v[dim - 1] = 0;
        }
    }

    /**
     * Esplosione delle sfere
     *
     * @param v vettore
     */
    public static void esplosione(int[] v) {
        System.out.println("Esplosione del vettore");
        boolean esploso; // variabile booleana per controllare se è esploso
        do { // ciclo do-while per controllare se ci sono sfere uguali
            esploso = false; // inizializzo a false
            int i = 0; // variabile per la posizione a 0
            while (i < dim - 1) { // scorro il vettore
                if (v[i] == v[i + 1] && v[i] != 0) { // controllo se le sfere sono uguali
                    int j = i; // contatore per sfere uguali
                    while (j < dim - 1 && v[j] == v[j + 1]) { // controllo se ci sono sfere uguali
                        j++; // incremento sfere uguali
                    }
                    for (int k = j + 1; k < dim; k++) { // ciclo for per spostare le sfere
                        v[k - (j - i + 1)] = v[k]; // sposto le sfere
                    }
                    for (int k = dim - (j - i + 1); k < dim; k++) {
                        v[k] = 0; // riempio gli spazi vuoti con 0
                    }
                    esploso = true; // setto a true
                } else {
                    i++; // incremento la posizione
                }
            }
        } while (esploso); // finché ci sono sfere uguali
        stampaVettore(v); // stampo il risultato
    }

    public static int sfereRimosse(int[] v) {
        int cont = 0;
        for (int i = 0; i < dim; i++) {
            if (v[i] == 0) {
                cont++;
            }
        }
        return cont;
    }

    // public static int simulaMossa(int[] v, int pos) {

    // }

    public static int mossaMigliore(int[] v) {
        int mossaMigliore = 0;
        int cont = 0;

        while (cont < dim - 3) {
            if (v[cont] == v[cont + 2] && v[cont] != v[cont + 1]) {
                mossaMigliore = cont + 1;
            }
            cont++;
        }

        return mossaMigliore;
    }


}

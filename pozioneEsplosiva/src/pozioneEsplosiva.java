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

        System.out.println("");
        esplosione(v);
    }

    /**
     * Funzione per stampare il vettore
     * @param v vettore da stampare
     */
    public static void stampaVettore(int[] v) {
        System.out.print("[");
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.print("]");
    }

    public static void riempiVettore(int[] v) {
        // colori
        /*
        * rosso = 1
        * verde = 2
        * giallo = 3
        * blu = 4
        */
        if(dim < dimMax) {

            for (int i : v) {
                v[dim] = r.nextInt(1, 5);
                dim++;
            }

        }
    }

    public static void togliSfera(int[] v, int pos) {
        if (pos > 0 && pos < dimMax) {
            v[pos] = 0;
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
                if (v[i] == v[i + 1]) { // controllo se le sfere sono uguali
                    int j = i; // contatore per sfere uguali
                    while (j < dim - 1 && v[j] == v[j + 1]) { // controllo se ci sono sfere uguali
                        j++; // incremento sfere uguali
                    }
                    for (int k = j + 1; k < dim; k++) { // ciclo for per spostare le sfere
                        v[k - (j - i + 1)] = v[k]; // sposto le sfere
                    }
                    int nuoviElementi = j - i + 1; // numero di nuovi elementi da aggiungere
                    dim -= nuoviElementi; // decremento la dimensione logica per gestire nuovi riempimenti
                    for (int k = dim; k < dim + nuoviElementi; k++) {
                        v[k] = r.nextInt(4); // riempio gli spazi vuoti con nuovi colori casuali
                    }
                    dim += nuoviElementi; // ripristino la dimensione logica
                    esploso = true; // setto a true
                } else { // se non ci sono sfere uguali
                    i++; // incremento la posizione
                }
            }

        } while (esploso); // finché ci sono sfere uguali
        stampaVettore(v); // stampo il risultato
    }

}
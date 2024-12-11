
import java.util.Scanner;

public class App {

    // variabili globali
    // contatore di elementi utilizzati (dimensione logica)
    static int dim = 0;
    // dimensione fisica del vettore
    static final int DIM_MAX = 20;

    public static void main(String[] args) throws Exception {
        try ( // variabili locali
            Scanner in = new Scanner(System.in)) {
            int[] vettore = new int[DIM_MAX];
            
            // System.out.println(Arrays.toString(vettore));
            stampa(vettore);
            
            appendiValore(vettore, 1); // chiamata di func
            appendiValore(vettore, 2);
            appendiValore(vettore, 3);
            appendiValore(vettore, 4);
            stampa(vettore);
            
            for (int i = 0; i < dim; i++) {
                System.out.println("Inserisci il valore e la posizione in cui vuoi inserirlo");
                nuovoElemento(vettore, in.nextInt(), in.nextInt());
                stampa(vettore);
            }
        }

    }

    /**
     * Aggiunge un valore al vettore
     *
     * @param v vettore
     */
    //visualizzare il vettore
    static void stampa(int[] v) {
        // stampo l'apertura dell'array
        System.out.print("[");

        // ciclo per stampare tutti gli elementi
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }

        // stampo la chiusura dell'array
        System.out.println("]");

    }

    // inserire valori nel vettore
    /**
     * Inserisce un nuovo valore in coda al vettore
     *
     * @param v vettore da modificare
     * @param nuovo il nuovo elemento da inserire
     * @return esito dell'inserimento
     * @param posizione posizione in cui inserire il nuovo valore
     */
    static boolean appendiValore(int[] v, int nuovo) {

        // vedo se c'è spazio
        if (dim < DIM_MAX) {

            // inserisco il valore
            v[dim] = nuovo;

            // aggiorno la dimensione
            dim++;

            // restituzione del valore
            return true;
        } else {
            // non c'è spazio
            System.err.println("Non c'è spazio");
            // restituzione del valore
            return false;
        }

    }

    /**
     * Inserisce un nuovo valore in una posizione specifica del vettore
     *
     * @param v vettore da modificare
     * @param nuovoValore il nuovo elemento da inserire
     * @param posizione posizione in cui inserire il nuovo valore
     * @return esito dell'inserimento
     */
    static boolean nuovoElemento(int[] v, int nuovoValore, int posizione) {
        // controllo se la posizione è valida
        if (posizione < 0 || posizione > dim) {
            System.err.println("Posizione non valida");
            return false;
        }

        // inserisco il nuovo valore
        v[posizione] = nuovoValore;

        // restituisco true
        return true;

    }

}

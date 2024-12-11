
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

            appendiValore(vettore, 1);
            appendiValore(vettore, 2);
            appendiValore(vettore, 3);
            appendiValore(vettore, 56);
            stampa(vettore);

            // funzione cerca
            System.out.println("Inserisci il valore da cercare");
            cerca(vettore, in.nextInt());

        }

    }

    /**
     * Aggiunge un valore al vettore
     *
     * @param v vettore
     */
    //visualizzare il vettore
    static void stampa(int[] v) {
        System.out.print("[");

        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }

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
            System.out.println("Non c'è spazio");
            // inserisco il valore
            v[dim] = nuovo;

            // aggiorno la dimensione
            dim++;

            return true;
        } else {
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
    /*
    static boolean nuovoElemento(int[] v, int nuovoValore, int posizione) {
        // controllo se la posizione è valida
        if (posizione < 0 || posizione > dim) {
            System.out.println("Posizione non valida");
            return false;
        }

        // controllo se c'è spazio
        if (dim < DIM_MAX) {
            // sposto i valori a destra
            for (int i = dim; i > posizione; i--) {
                v[i] = v[i - 1];
            }

            // inserisco il nuovo valore
            v[posizione] = nuovoValore;

            // aggiorno la dimensione
            dim++;

            return true;
        } else {
            System.out.println("Non c'è spazio");
            return false;
        }

    }
     */
    /**
     * Elimina un valore in una posizione specifica del vettore
     *
     * @param v vettore da modificare
     * @param pos posizione in cui eliminare il valore
     * @return esito dell'eliminazione
     */
    /*
    static boolean elimina(int[] v, int pos) {
        for (int i = pos + 1; i < dim; i++) {
            v[i - 1] = v[i];
        }

        dim--;

        return true;

    }  
     */
    /**
     * Cerca un valore nel vettore
     *
     * @param v vettore in cui cercare
     * @param valore valore da cercare
     * @return true se il valore è presente, false altrimenti
     */
    static boolean cerca(int[] v, int valore) {

        for (int i = 0; i < dim; i++) {
            if (v[i] == valore) {
                System.out.println("Valore presente in posizione " + i);
                return true;
            }
        }
        System.err.println("Valore non presente");
        return false;
    }

}


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
            // nuovo elemento, per utilizzare il metodo
            nuovoElemento(vettore, 1, 4);

            stampa(vettore);

            for (int i = 0; i < dim; i++) {
                System.out.println("Inserisci la posizione");
                elimina(vettore, in.nextInt());
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

    static boolean elimina(int[] v, int pos) {
        for (int i = pos + 1; i < dim; i++) {
            v[i - 1] = v[i];
        }

        dim--;

        return true;

    }

}

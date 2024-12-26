
import java.util.*;

public class holidayHomework {

    // variabili globali
    static int dim = 0; // dimensione logica del vettore
    static int DIM_MAX = 15; // dimensione massima del vettore
    static Scanner in = new Scanner(System.in); // Scanner per l'input
    static Random r = new Random(); // Random per la generazione di numeri casuali

    public static void main(String[] args) throws Exception {
        int[] v = new int[DIM_MAX]; // vettore con dimensione massima 

        int tentativi = 0;

        System.out.println("Inserisci il numero di sfere con cui vuoi giocare");
        int dimSfere = in.nextInt(); // dimensione array iniziale
        // riempio il vettore 
        for (int i = 0; i < dimSfere; i++) {
            riempiVettore(v, r.nextInt(0, 4));
        }

        // stampo il risultato
        stampa(v);

        boolean fine = false;

        while (!fine) {
            // esplosioni
            esplosione(v);
            stampa(v);

            // 2 per essere sicuri di non avere sfere attaccate
            esplosione(v);
            stampa(v);

            // si vince se il vettore è vuoto e quindi tutte le palline sono state eliminate
            if (dim == 0) {
                System.out.println("Hai impiegato " + tentativi + " tentativi");
                break; // break per bypassare tutta la parte restante del ciclo
            }

            System.out.println("Mossa migliore " + mossaMigliore(v));

            // simulaMossa
            System.out.println("Vuoi simulare una mossa? (s/n)");
            char n = in.next().charAt(0);
            if (n == 's') {
                System.out.println("Inserisci la posizione da simulare");
                simulaMossa(v, in.nextInt());
            }
            System.out.println("Inserisci la posizione della sfera da eliminare");
            // elimino la sfera
            togliSfera(v, in.nextInt());
            // stampo il risultato
            stampa(v);

            // aumento il numero di tentativi utilizzati
            tentativi++;

        }

    }

    /**
     * Riempie il vettore con un colore
     *
     * @param v vettore
     * @param colore colore da inserire
     */
    public static void riempiVettore(int[] v, int colore) {
        // 4 colori, associati ad un numero

        /*
        int rosso = 0;
        int blu = 1;
        int giallo = 2;
        int verde = 3;
         */
        // inserisco il colore nel vettore 
        v[dim] = colore;
        // incremento la posizione logica
        dim++;
    }

    /**
     * Stampa il vettore
     *
     * @param v vettore da stampare
     */
    public static void stampa(int[] v) {
        System.out.print("["); // parentesi quadra iniziale
        for (int i = 0; i < dim; i++) { // numeri inseriti
            System.out.print(v[i] + " ");
        }
        System.out.println("]"); // parentesi quadra finale
    }

    /**
     * Esplosione delle sfere
     *
     * @param v vettore
     */
    public static void esplosione(int[] v) {
        // contatore per scorrere il vettore
        int i = 0;
        // finchè non ho finito il vettore
        while (i < dim - 1) {
            // se ci sono due sfere uguali
            if (v[i] == v[i + 1]) {
                int j = i; // contatore per scorrere le sfere uguali
                while (j < dim - 1 && v[j] == v[j + 1]) { // scorro tutto il vettore
                    j++; // conto quante sfere uguali ci sono
                }
                // Sposta gli elementi a sinistra
                for (int k = j + 1; k < dim; k++) {
                    v[k - (j - i + 1)] = v[k];
                }
                // Aggiorna la dimensione logica
                dim -= (j - i + 1);
            } else {
                i++;
            }
        }
    }

    /**
     * Elimina una sfera dal vettore
     *
     * @param v vettore
     * @param pos posizione della sfera da eliminare
     */
    public static void togliSfera(int v[], int pos) {
        // controllo che la posizione sia valida
        if (pos < 0 || pos >= dim) {
            System.out.println("Posizione non valida");
        }

        // Sposta gli elementi a sinistra
        for (int i = pos; i < dim - 1; i++) {
            v[i] = v[i + 1];
        }
        // Aggiorna la dimensione logica
        dim--;
    }

    /**
     * Simula una mossa
     *
     * @param v vettore
     * @param pos posizione da simulare
     */
    public static void simulaMossa(int[] v, int pos) {
        if (dim > 2 && pos < dim - 3) { // controllo che ci siano almeno 3 sfere e che la posizione sia valida
            if (v[pos] == v[pos + 2]) { // controllo che le sfere siano uguali
                System.out.println("La mossa porterà ad un'esplosione"); // stampo il risultato
            } else {
                System.out.println("La mossa non porterà ad un'esplosione"); // stampo il risultato
            }
        } else {
            System.out.println("Fine gioco"); // se nessuna delle condizioni è soddisfatta, stampo fine gioco
        }

    }

    /**
     * Calcola la mossa migliore
     *
     * @param v vettore
     * @return posizione della mossa migliore
     */
    public static int mossaMigliore(int[] v) {
        int pos = 0; // posizione
        int possibiliEsplosioni = 0; // contatore delle possibili esplosioni
        int mossaMigliore = 0;
        while (pos < dim - 3) { // finchè non ho finito il vettore
            if (v[pos] == v[pos + 2]) { // controllo che le sfere siano uguali
                mossaMigliore = pos + 1; // la mossa migliore è la posizione + 1
                possibiliEsplosioni++; // incremento il contatore delle possibili esplosioni
            }
            pos++;
        }
        System.out.println("Possibili esplosioni: " + possibiliEsplosioni);
        return mossaMigliore; // ritorno la mossa migliore
    }

}

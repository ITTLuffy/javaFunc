
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

        // esplosione
        esplosione(v);
        stampa(v);

        // esplosione
        esplosione(v);
        stampa(v);

        boolean fine = false;

        while (!fine) {
            esplosione(v);
            stampa(v);

            if (dim == 0) {
                fine = true;
                System.out.println("Hai impiegato " + tentativi + " tentativi");
                break;
            }

            mossaMigliore(v);
            
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
        System.out.print("[");
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Esplosione delle sfere
     *
     * @param v vettore
     */
    public static void esplosione(int[] v) {
        System.out.println("Esplosione");
        // contatore per scorrere il vettore
        int i = 0;
        // finchè non ho finito il vettore
        while (i < dim - 1) {
            // se ci sono due sfere uguali
            if (v[i] == v[i + 1]) {
                int j = i;
                while (j < dim - 1 && v[j] == v[j + 1]) {
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

    public static void simulaMossa(int[] v, int pos) {
        if (dim > 2) {
            if (v[pos - 1] == v[pos + 1]) {
                System.out.println("La mossa porterà ad un'esplosione");
            } else {
                System.out.println("La mossa non porterà ad un'esplosione");
            }
        } else {
            System.out.println("Fine gioco");
        }

    }

    public static void mossaMigliore(int[] v) {
        int pos = 0;
        int max = 0;
        for (int i = 0; i < dim; i++) {
            if (v[i] == v[i + 1]) {
                int j = i;
                while (j < dim - 1 && v[j] == v[j + 1]) {
                    j++;
                }
                if (j - i + 1 > max) {
                    max = j - i + 1;
                    pos = i;
                }
            }
        }
        System.out.println("La mossa migliore è " + pos);
    }

}


import java.util.*;

/**
 * giocatore 1 = g1 giocatore 2 = g2 rosso = 1 blu = 2 giallo = 3 verde = 4
 */

public class pozioneEsplosiva {

    public static Scanner in = new Scanner(System.in);
    public static Random r = new Random();
    public static int dim = 0; // dimensione dinamica g1
    public static int dim2 = 0; // dimensione dinamica g2
    public static int dimMax = 0; // variabile per la dimensione massima del vettore

    public static void main(String[] args) {

        System.out.println("********************************************");
        System.out.println("\n");
        System.out.println("            POZIONE ESPLOSIVA ");
        System.out.println("\n");
        System.out.println("********************************************");
        System.out.println("L'obiettivo del gioco è rimuovere il maggior numero di palline possibili in una sola mossa :)");

        // dimensione array g1
        System.out.println("Inserisci la lunghezza del vettore con il quale volete giocare");
        dimMax = in.nextInt();

        // array g1
        int[] v = new int[dimMax];

        // riempio il vettore
        riempiVettore(v);
        // stampo il vettore
        stampaVettore(v);

        dim = 0; // resetto la dimensione

        // array g2
        int[] v2 = new int[dimMax];

        // riempio il vettore
        riempiVettore(v2);
        // stampo il vettore
        stampaVettore(v2);


        // mossa migliore g1
        int mossaMigliore = mossaMigliore(v);
        System.out.println("Mossa migliore g1: " + mossaMigliore);

        // mossa migliore g2
        mossaMigliore = mossaMigliore(v2); // riutilizzo la variabile
        System.out.println("Mossa migliore g2: " + mossaMigliore);

        // simula mossa g1
        System.out.println("G1: vuoi simulare una mossa? (s/n)");
        char risposta = in.next().charAt(0);
        while (risposta == 's') {
            System.out.println("Inserisci la posizione della sfera da togliere");
            int pos = in.nextInt();
            int simulaMossa = simulaMossa(v, pos);
            System.out.println("La mossa porterebbe a rimuovere " + simulaMossa + " sfere");
            System.out.println("Vuoi simulare un'altra mossa? (s/n)");
            risposta = in.next().charAt(0);
        }

        // simula mossa g2
        System.out.println("G2: vuoi simulare una mossa? (s/n)");
        risposta = in.next().charAt(0); // utilizzo la stessa variaible di prima
        while (risposta == 's') {
            System.out.println("Inserisci la posizione della sfera da togliere");
            int pos = in.nextInt();
            int simulaMossa = simulaMossa(v2, pos);
            System.out.println("La mossa porterebbe a rimuovere " + simulaMossa + " sfere");
            System.out.println("Vuoi simulare un'altra mossa? (s/n)");
            risposta = in.next().charAt(0);
        }


        // rimuovi sfera
        System.out.println("G1: inserisci la posizione della sfera da togliere");
        togliSfera(v, in.nextInt());

        // esplosione dopo la rimozione
        esplosione(v);

        // calcolo delle sfere rimosse
        int sfereRimosse = sfereRimosse(v);
        System.out.println("Sono state rimosse " + sfereRimosse + " sfere dal g1");

        // rimuovi sfera
        System.out.println("G2: inserisci la posizione della sfera da togliere");
        togliSfera(v2, in.nextInt());

        // esplosione dopo la rimozione
        esplosione(v2);

        // calcolo delle sfere rimosse
        int sfereRimosse2 = sfereRimosse(v2);
        System.out.println("Sono state rimosse " + sfereRimosse2 + " sfere dal g2");

        if (sfereRimosse > sfereRimosse2) {
            System.out.println("Il vincitore è il g1");
        } else if (sfereRimosse < sfereRimosse2) {
            System.out.println("Il vincitore è il g2");
        } else {
            System.out.println("Pareggio");
        }

    }

    /**
     * Funzione per stampare il vettore
     *
     * @param v vettore da stampare
     */
    public static void stampaVettore(int[] v) {
        // parentesi quadra iniziale
        System.out.print("[");
        // ciclo for per stampare il vettore
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }
        // parentesi quadra finale
        System.out.println("]");
    }

    /**
     * Funzione per riempire il vettore
     *
     * @param v vettore da riempire
     */
    public static void riempiVettore(int[] v) {
        // ciclo for per riempire il vettore
        for (int i = 0; i < v.length; i++) {
            // riempio il vettore con numeri casuali tra 1 e 5
            v[dim] = r.nextInt(1, 5);
            // incremento la dimensione
            dim++; // la dimensione funge come indice
        }
        
    }

    /**
     * Funzione per togliere una sfera
     *
     * @param v vettore
     * @param pos posizione della sfera da togliere
     */
    public static void togliSfera(int[] v, int pos) {
        // controllo che la posizione sia valida
        if (pos > 0 && pos < dimMax) {
            // ciclo for per spostare le sfere
            for (int i = pos; i < dim - 1; i++) {
                // sposto le sfere
                v[i] = v[i + 1];
            }
            v[dim - 1] = 0; // riempio l'ultimo spazio con 0
        } else {
            System.out.println("Posizione non valida");
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
                if (v[i] == v[i + 1] && v[i] != 0) { // controllo se le sfere sono uguali e diverse da 0
                    int j = i; // contatore per sfere uguali
                    while (j < dim - 1 && v[j] == v[j + 1]) { // controllo se ci sono sfere uguali
                        j++; // incremento sfere uguali
                    }
                    for (int k = j + 1; k < dim; k++) { // ciclo for per spostare le sfere
                        v[k - (j - i + 1)] = v[k]; // sposto le sfere
                    }
                    for (int k = dim - (j - i + 1); k < dim; k++) { // ciclo for per riempire gli spazi vuoti
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

    /**
     * Funzione per contare le sfere rimosse
     *
     * @param v vettore
     * @return contatore delle sfere rimosse
     */
    public static int sfereRimosse(int[] v) {
        // contatore delle sfere rimosse
        int cont = 0;
        for (int i = 0; i < dim; i++) { // ciclo che scorre il vettore
            // aumento il contatore delle sfere rimosse
            if (v[i] == 0) {
                cont++;
            }
        }
        // ritorno il contatore
        return cont;
    }

    /**
     * Funzione per trovare la mossa migliore
     *
     * @param v vettore
     * @return mossa migliore
     */
    public static int mossaMigliore(int[] v) {
        // mossa migliore
        int mossaMigliore = 0;

        // contatore
        int cont = 0;

        // scorro il vettore
        while (cont < dim - 3) {
            if (v[cont] == v[cont + 2] && v[cont] != v[cont + 1]) { // controllo se ci sono sfere uguali separate da una sfera diversa
                mossaMigliore = cont + 1; // setto la mossa migliore
            }
            cont++; // incremento il contatore
        }
        // ritorno la mossa migliore
        return mossaMigliore;
    }

    /**
     * Funzione per simulare una mossa
     *
     * @param v vettore
     * @param pos posizione della sfera da togliere
     * @return sfere rimosse
     */
    public static int simulaMossa(int[] v, int pos) {
        // creo una copia del vettore
        int[] vCopia = Arrays.copyOf(v, dim);

        // rimuovo la sfera dalla posizione
        togliSfera(vCopia, pos);

        // simulo le esplosioni
        esplosione(vCopia);

        // e ritorno le sfere rimosse
        return sfereRimosse(vCopia);
    }

}

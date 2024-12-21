
import java.util.Random;
import java.util.Scanner;

public class holidayHomework {

    // variabili globali
    static int dim = 0; // dimensione logica del vettore
    static int DIM_MAX = 15; // dimensione massima del vettore
    static Scanner in = new Scanner(System.in); // Scanner per l'input
    static Random r = new Random(); // Random per la generazione di numeri casuali

    public static void main(String[] args) throws Exception {
        int[] v = new int[DIM_MAX]; // vettore con dimensione massima 

        System.out.println("Inserisci il numero di sfere con cui vuoi giocare");
        int dimSfere = in.nextInt();
        // riempio il vettore 
        for (int i = 0; i < dimSfere; i++) {
            riempiVettore(v, r.nextInt(0, 4));
        }

        stampa(v);

        System.out.println("Inserisci la posizione della sfera da eliminare");
        togliSfera(v, in.nextInt());
        stampa(v);
    }

    public static void riempiVettore(int[] v, int colore) {
        // 4 colori, associati ad un numero
        int rosso = 0;
        int blu = 1;
        int giallo = 2;
        int verde = 3;

        v[dim] = colore;
        dim++;

    }

    public static void stampa(int[] v) {
        System.out.print("[");
        for (int i = 0; i < dim; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("]");
    }

    public static void togliSfera(int v[], int pos) {
        if (pos < 0 || pos >= dim) {
            System.err.println("Posizione non valida");
            System.exit(0);
        }

        for (int i = pos + 1; i < dim; i++) {
            v[i - 1] = v[i];
        }
        dim--;
    }

}

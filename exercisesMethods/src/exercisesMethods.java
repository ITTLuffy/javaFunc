import java.util.Scanner;

public class exercisesMethods {
    /*
    Creare un metodo che prenda come argomento un numero intero e stampi 
    a video i 10 numeri successivi (fai l’esercizio sia con ciclo for che con while).
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero");
        int n = in.nextInt();
        stampa(n);
    }

    public static void stampa(int n) {
        for (int i = n; i <= n+10; i++) {
            System.out.println(i);
        }
    }
}

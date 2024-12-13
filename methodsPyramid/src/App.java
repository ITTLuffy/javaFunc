
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci un numero DISPARI");
        int n = in.nextInt();
        conoRovescio(n);
        in.close();
    }

    /**
     * Metodo che prende come argomento un numero e stampa a video un albero capovolto
     * @param n numero massimo
     */
    public static boolean conoRovescio(int n) {
        if (n % 2 != 0) {
            int righe = (n/2)+1; // righe che verranno stampate
        
            // numero di asterischi
            int contaCar = n;
    
            // numero di spazi       
            int contaSpa = 0;
    
            for (int i = righe; i > 0; i--) {
                // per spazi
                for (int j = 0; j < contaSpa; j++) {
                    System.out.print(" ");
                }
                contaSpa++;
                // per asterischi
                for (int k = 0; k < contaCar; k++) {
                    System.out.print("*");
                }
                contaCar-=2;
                // a capo
                System.out.println(" ");
            }    
            return true;

        } else {
            System.err.println("Wrong");
            return false;

        }

    }
    
}

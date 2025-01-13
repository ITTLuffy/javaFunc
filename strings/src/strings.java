
import java.util.Scanner;

public class strings {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String stringa = "";
        int chiave = 0;
        messaggio(stringa, chiave);
    }

    public static String messaggio(String messaggio, int k) {
        System.out.println("Inserisci il messaggio segreto");
        messaggio = in.next();
        System.out.println("Inserisci la chiave, possibilmente uguale a 3");
        k = in.nextInt();
        // contatore posizione stringa
        int cont = 0;
        // contatore quante volte eseguire il ciclo
        int contChiave = 0;
        int riga = 1;
        // ciclo per eseguire 
        while (contChiave < k) {
            // ciclo che stampa 
            while (cont < messaggio.length()) {
                System.out.print(messaggio.charAt(cont));
                if (riga % 2 == 0) {
                    cont += 2;
                } else {
                    cont += k + 1;
                }
            }

            // aggiorno il contatore
            contChiave++;

            // contatore per stampare singole parole
            cont = riga;
            
            // 
            riga++;

        }
        
        return messaggio;

    }

}

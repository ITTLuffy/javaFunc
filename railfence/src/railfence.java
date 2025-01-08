
import java.util.Scanner;

// fare una funzione per cifrare una frase, con il metodo railfence

public class railfence {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci il messaggio segreto");
        String messaggio = in.next();
        System.out.println("Inserisci la chiave, possibilmente uguale a 3");
        int k = in.nextInt();

        String segreto = staccionata(messaggio, k);

        System.out.println(segreto);
    }

    static String staccionata(String messaggio, int k) {

        String risultato = "";

        // righe
        String[] righe = new String[k];

        // inizializzo le righe
        for (int i = 0; i < k; i++) {
            righe[i] = "";
        }

        int r = 0;
        boolean down = true;

        for (char c : messaggio.toCharArray()) {
            righe[r] += c;
            if (down) {
                r++;
            } else {
                r--;
            }
            if (r == k - 1) {
                down = false;
            }
            if (r == 0) {
                down = true;
            }
        }

        for (String s : righe) {
            risultato += s;
        }

        return risultato;
    }

}

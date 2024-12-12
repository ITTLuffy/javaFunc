import java.util.Scanner;
/*ferro troppo forte*/
public class App {

    public static void main(String[] args) throws Exception {

        try (Scanner in = new Scanner(System.in)) {
            boolean sentinella;

            sentinella = true;

            while (sentinella) {
                System.out.println("Quale operazione vuoi fare?");
                System.out.println("Premi 1 per addizione, premi 2 per sottrazione, premi 3 per divisione, premi 4 per moltiplicazione e premi 0 per uscire");

                int nInserito = in.nextInt();

                switch (nInserito) {
                    case 1 -> {
                        System.out.println("Inserisci due numeri");
                        int somma = addizione(in.nextInt(), in.nextInt());
                        System.out.println(somma);
                    }
                    case 2 -> {
                        System.out.println("Inserisci due numeri");
                        int somma2 = sottrazione(in.nextInt(), in.nextInt());
                        System.out.println(somma2);
                    }
                    case 3 -> {
                        System.out.println("Inserisci due numeri");
                        float somma3 = divisione(in.nextFloat(), in.nextInt());
                        System.out.println(somma3);
                    }
                    case 4 -> {
                        System.out.println("Inserisci due numeri");
                        int somma4 = moltiplicazione(in.nextInt(), in.nextInt());
                        System.out.println(somma4);
                    }
                    case 0 -> {
                        System.err.println("Uscita");
                        sentinella = false;
                    }
                }

            }
        }

    }

    public static int addizione(int n1, int n2) {
        return n1 + n2;
    }

    public static int sottrazione(int n1, int n2) {
        return n1 - n2;
    }

    public static float divisione(float n1, int n2) {
        return n1 / n2;
    }

    public static int moltiplicazione(int n1, int n2) {
        return n1 * n2;
    }

}

import java.util.Arrays;
import java.util.Random;

public class holidayHomework {

    public static int dim = 4;
    public static final int MAX_DIM = 20;

    public static void main(String[] args) throws Exception {
        Random r = new Random();
        int[] v = new int[dim];
        for (int i = 0; i < v.length; i++) {
            riempiVettore(v, r.nextInt(0, 4), i);
        }
        System.out.println(Arrays.toString(v));
    }

    public static void riempiVettore(int[] v, int colore, int pos) {
        // 4 colori, associati ad un numero
        int rosso = 0;
        int blu = 1;
        int giallo = 2; 
        int verde = 3;   

        for (int i : v) {
            v[pos] = colore;
            dim++;
        }

    }
}

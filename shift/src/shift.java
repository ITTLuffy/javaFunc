
import java.util.Arrays;
import java.util.Random;

public class shift {

    public static void main(String[] args) throws Exception {
        int[] v = new int[6];
        Random r = new Random();
        for (int i = 0; i < v.length; i++) {
            v[i] = r.nextInt(1, 10);
        }

        System.out.println(Arrays.toString(v));
        int[] v2 = vettore(v);
        System.out.println(Arrays.toString(v2));
    }

    public static int[] vettore(int[] v) {
        int[] v2 = Arrays.copyOf(v, v.length);
        v2[0] = v[v.length - 1];
        for (int i = 1; i < v.length; i++) {
            v2[i] = v[i - 1];
        }
        return v2;
    }
}

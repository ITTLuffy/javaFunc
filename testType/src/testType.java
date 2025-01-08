import java.util.Arrays;
import java.util.Random;

public class testType {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        int[] v = new int[6]; // array
        for (int i = 0; i < v.length; i++) {
            v[i] = r.nextInt(1, 10);
        }
        System.out.println(Arrays.toString(v));
        int[] v2 = shift(v);
        System.out.println(Arrays.toString(v2));
    }

    public static int[] shift(int[] v) {
        int[] v2 = Arrays.copyOf(v, 7);
        Arrays.fill(v2, 0);
        for (int i = 0; i < v.length-1; i--) {
            v[i] = v2[i+1];
        }
        v2[6] = v2[0];
        return v2;


    }
}


public class exercisesCorrection {
    public static void main(String[] args) throws Exception {
        int[] vet = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        occorrenze(vet, 5);


    }
    // contare le occorrenze di un certo elemento in un array
    public static void occorrenze(int[] v, int valore) {
        int occorrenze = 0;
        for (int i : v) {
            if (v[i] == valore) {
                occorrenze++;
            }
        }
        System.out.println("L'elemento " + valore + " è presente " + occorrenze + " volte");
    }

}
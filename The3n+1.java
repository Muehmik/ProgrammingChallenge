import java.util.Scanner;

public class The3n+1 {

    public static int cycleLength(int n){
        return n == 1 ? 1 : 1 + cycleLength(n % 2 == 0 ? n / 2 : 3 * n + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt(),
                    j = in.nextInt(),
                    from = Math.min(i, j),
                    to = Math.max(i, j),
                    max = 0;

            for (int n = from; n <= to; n++) {
                max = Math.max(max, cycleLength(n));
            }

            System.out.printf("%d %d %d\n", i, j, max);
        }
    }
}


import java.util.Scanner;

/**
 * Created by donny.kim on 2015-01-08.
 */
public class Minesweeper {
    static char[][] minefield;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;

        while (true) {
            count++;
            int n = sc.nextInt(),
                    m = sc.nextInt();

            if (n == 0 && m == 0)
                break;
            else
                minefield = new char[n][m];

            for (int i = 0; i < n; i++) {
                line = sc.next();
                for (int j = 0; j <m ; j++) {
                    minefield[i][j] = line.charAt(j);
                }
            }

            countMines(minefield);
            printMap(minefield);
        }
    }

    private static void printMap(char[][] mines) {
        System.out.println("Field #" + count + ":");
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines[i].length; j++) {
                System.out.print(mines[i][j]);
            }
            System.out.println();
        }
    }

    private static void countMines(char[][] mines) {
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines[i].length; j++) {
                if (mines[i][j] == '*') {
                    mines = addAround(i, j, mines.length, mines[i].length, mines);
                } else if (mines[i][j] == '.') {
                    mines[i][j] = '0';
                }
            }
        }
    }

    private static char[][] addAround(int i, int j, int iLength, int jLength, char[][] mines) {
        for (int a = i - 1; a <= i + 1; a++) {
            for (int b = j - 1; b <= j + 1; b++) {
                if (checkBorder(iLength, jLength, a, b) && (mines[a][b] != '*')) {
                    if (mines[a][b] == '.') {
                        mines[a][b] = '0';
                    }
                    int temp = mines[a][b];
                    temp++;
                    mines[a][b] = (char) temp;
                } else {
                }
            }
        }

        return mines;
    }

    private static boolean checkBorder(int strLength, int chLength, int i, int j) {
        boolean isBorder = false;

        if ((i < 0) || (j < 0) || (i > strLength - 1) || (j > chLength - 1)) {
        } else {
            isBorder = true;
        }
        return isBorder;
    }
}

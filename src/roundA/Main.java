package roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SolutionB solution = new SolutionB();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int r = in.nextInt();
            int c = in.nextInt();
            in.nextLine();
            char[][] grids = new char[r][c];
            for (int i=0; i<r; i++) {
                String row = in.nextLine();
                for (int j=0; j<c; j++) {
                    grids[i][j] = row.charAt(j);
                }
            }
            System.out.println("Case #" + t + ": " + solution.parcels(grids, r, c));
        }
    }
}
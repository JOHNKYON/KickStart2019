package warming_up.roundA2018;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
        System.out.println(solution.closestNumber(n));
        }
    }
}
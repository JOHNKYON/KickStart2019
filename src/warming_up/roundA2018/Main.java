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
            int k = in.nextInt();
            double[] nums = new double[n];
            double[] sums = new double[n+1];
            for (int j=0; j<n; j++) {
                nums[j] = in.nextLong();
            }
            Arrays.sort(nums);
            for (int j=0; j<n; j++) {
                sums[j + 1] = sums[j] + nums[j];
            }
            System.out.println("Case #" + i + ": " + solution.expectedValueNaive(nums, n, k, sums));
        }
    }
}
package warming_up.roundA2018;

import java.util.Arrays;

class Solution {
    long closestNumber(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        for (int i=0; i<sb.length(); i++) {
            int digit = sb.charAt(i) - '0';
            if ((digit & 1) == 1) {
                if (i == sb.length() - 1)
                    return 1;
                String restString = sb.substring(i+1, sb.length());
                int len = restString.length();
                long restVal = Long.parseLong(restString);
                long threshold = 0;
                for (int j=0; j<len; j++) {
                    threshold *= 10;
                    threshold += 4;
                }
                if (restVal > threshold && digit != 9) {
                    sb.replace(i, i+1, "" + (digit+1));
                    sb.delete(i+1, sb.length());
                    for (int j=0; j<len; j++) {
                        sb.append(0);
                    }
                } else {
                    sb.replace(i, i+1, "" + (digit-1));
                    sb.delete(i+1, sb.length());
                    for (int j=0; j<len; j++) {
                        sb.append(8);
                    }
                }
                break;
            }
        }
        return Math.abs(n - Long.parseLong(sb.toString()));
    }

    static double expectedValueNaive(double[] nums, int n, int k, double[] sums) {
        if (n == 0)
            return 0.0;
        if (k == 0)
            return sums[n] / n;
        double expectedNext = expectedValueNaive(nums, n, k-1, sums);
        int idx = Arrays.binarySearch(nums, expectedNext);
        if (idx < 0) {
            idx = - (idx + 1);
        }
        double greaterSum = sums[n] - sums[idx];
        double greaterExp = greaterSum / n;
        return greaterExp + expectedNext * ((double)idx / n);
    }
}

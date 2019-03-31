package roundA;

import java.util.*;

class SolutionA {
    long train(long[] nums, int n, int k) {
        Arrays.sort(nums);
        long window = 0l;
        int i = 0;
        long high = nums[k-1];
        for (i=0; i<k; i++) {
            window += high - nums[i];
        }
        long ans = window;
        long prevHigh = high;
        for(; i<n; i++) {
            high = nums[i];
            window -= prevHigh - nums[i-k];
            window += (high - prevHigh) * (k-1);
            ans = Math.min(ans, window);
            prevHigh = high;
        }
        return ans;
    }
}

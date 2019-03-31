package roundA;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionC {
    public int book(int[][] bookings, int n, int q) {
        int ans = n;
        Queue<Interval> heap = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.end - o1.start) - (o2.end - o2.start);
            }
        });
        for (int[] booking: bookings) {
            heap.offer(new Interval(booking[0], booking[1]));
        }

        boolean[] seats = new boolean[n];
        while(!heap.isEmpty()) {
            Interval curr = heap.poll();
            int thisBook = 0;
            for (int i=curr.start-1; i<curr.end; i++) {
                if (!seats[i]) {
                    thisBook++;
                    seats[i] = true;
                }
            }
            ans = Math.min(ans, thisBook);
        }

        return ans;
    }

    class Interval{
        int start;
        int end;

        public Interval(int _start, int _end){
            start = _start;
            end = _end;
        }
    }
}

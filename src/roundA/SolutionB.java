package roundA;

import java.util.*;

public class SolutionB {
    int[][] dists;
    int n, m;

    final static int[][] moves = {{1, 0},{-1, 0}, {0, 1}, {0, -1}};
    int parcels(char[][] grids, int r, int c) {
        if (r == 0 || c == 0)
            return 0;
        n = r;
        m = c;
        dists = new int[n][m];

        int k = mutipleBFS(grids);
        if (k <= 0)
            return 0;
        return binarySearch(grids, k);
    }

    private int binarySearch(char[][] grids, int k) {
        int left = 0, right = k;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean flag = canReach(grids, mid);
            if (flag) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canReach(char[][] grids, int k) {
        int maxPlus = Integer.MIN_VALUE, minPlus = Integer.MAX_VALUE;
        int maxSub = Integer.MIN_VALUE, minSub = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dists[i][j] > k) {
                    maxPlus = Math.max(maxPlus, i + j);
                    minPlus = Math.min(minPlus, i + j);
                    maxSub = Math.max(maxSub, i - j);
                    minSub = Math.min(minSub, i - j);
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grids[i][j] == '0') {
                    int dis = Math.max(Math.abs(i + j - maxPlus), Math.abs(i + j - minPlus));
                    dis = Math.max(Math.abs(i - j - maxSub), dis);
                    dis = Math.max(Math.abs(i - j - minSub), dis);
                    if (dis <= k)
                        return true;
                }
            }
        }
        return false;
    }

    private int mutipleBFS(char[][] grids) {
        Queue<int[]> candidates = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grids[i][j] == '1') {
                    candidates.offer(new int[]{i, j});
                    seen.add(i * m + j);
                }
            }
        }
        int step = 0;
        int size = candidates.size();
        while (!candidates.isEmpty()) {
            int[] curr = candidates.poll();
            int r = curr[0], c = curr[1];
            dists[r][c] = step;
            for (int[] move: moves) {
                int nr = r + move[0], nc = c + move[1];
                if (nr >=0 && nr < n &&
                        nc >= 0 && nc < m &&
                        grids[nr][nc] == '0' &&
                        !seen.contains(nr * m + nc)) {
                    candidates.offer(new int[]{nr, nc});
                    seen.add(nr * m + nc);
                }
            }

            size--;
            if (size == 0) {
                size = candidates.size();
                step++;
            }
        }
        return step-1;
    }



    int parcelsNaive(char[][] grids, int n, int m) {
        int ans = Integer.MAX_VALUE;
        boolean full = true;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grids[i][j] == '0') {
                    grids[i][j] = '1';
                    ans = Math.min(ans, bfsNaive(grids, n, m));
                    grids[i][j] = '0';
                    full = false;
                }
            }
        }

        if (full)
            return 0;

        return ans;
    }

    private int bfsNaive(char[][] grids, int n, int m) {
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grids[i][j] == '0')
                    ans = Math.max(ans, bfs(grids, i, j, n, m));
            }
        }
        return ans;
    }

    private static int bfs(char[][] grids, int r, int c, int n, int m) {
        Queue<int[]> candidates = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        candidates.offer(new int[]{r, c});
        int size = 1;
        int step = 0;
        while (!candidates.isEmpty()) {
            int[] curr = candidates.poll();

            for (int[] move: moves) {
                int nr = curr[0] + move[0];
                int nc = curr[1] + move[1];
                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < m &&
                        !seen.contains(nr * m + nc)) {
                    if (grids[nr][nc] == '1') {
                        return step+1;
                    } else {
                        candidates.offer(new int[]{nr, nc});
                        seen.add(nr * m + nc);
                    }
                }
            }

            size--;
            if (size == 0) {
                step++;
                size = candidates.size();
            }
        }
        return 0;
    }
}

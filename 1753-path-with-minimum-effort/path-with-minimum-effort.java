class Solution {
    int[][] minEffort;
    int[] rows = {-1, 1, 0, 0};
    int[] cols = {0, 0, -1, 1};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        minEffort = new int[m][n];
        for (int[] arr : minEffort) Arrays.fill(arr, Integer.MAX_VALUE);
        minEffort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0}); // {row, col, effort}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], effort = current[2];

            if (x == m - 1 && y == n - 1) return effort;

            for (int k = 0; k < 4; k++) {
                int ni = x + rows[k];
                int nj = y + cols[k];

                if (isValidIndex(ni, nj, heights)) {
                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[ni][nj]));

                    if (newEffort < minEffort[ni][nj]) {
                        minEffort[ni][nj] = newEffort;
                        pq.offer(new int[]{ni, nj, newEffort});
                    }
                }
            }
        }
        return -1; // Should not reach here
    }

    private boolean isValidIndex(int i, int j, int[][] heights) {
        return (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length);
    }
}
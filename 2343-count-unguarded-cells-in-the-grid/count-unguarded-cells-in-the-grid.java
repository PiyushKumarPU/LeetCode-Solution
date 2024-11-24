class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Create a grid with 0 (empty), 1 (guard), 2 (wall), 3 (guarded)
        int[][] grid = new int[m][n];
        
        // Place guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Mark cells as guarded
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != 1 && grid[nx][ny] != 2) {
                    grid[nx][ny] = 3; // Mark as guarded
                    nx += dir[0];
                    ny += dir[1];
                }
            }
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }
}
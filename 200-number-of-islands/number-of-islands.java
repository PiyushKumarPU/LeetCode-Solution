class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islandCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    islandCount++;
                    captureConnectedLand(i,j,grid);
                }
            }
        }
        return islandCount;
    }
    int[] rows = {-1,1,0,0};
    int[] cols = {0,0,-1,1};
    private void captureConnectedLand(int i, int j, char[][] grid){
        if(!isValidIndex(i,j,grid) || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for(int k = 0; k < 4;k++){
            //if(isValidIndex(i+rows[k],j + cols[k],grid) && grid[i+rows[k]][j + cols[k]] != '0')
                captureConnectedLand(i+rows[k], j + cols[k], grid);
        }
    }

    private boolean isValidIndex(int i, int j, char[][] grid){
        return i >=0 && i < grid.length && j >=0 && j < grid[i].length;
    }
}
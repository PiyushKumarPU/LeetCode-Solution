class Solution {
    
    char[][] matrix;
    public int numIslands(char[][] grid) {
        int count = 0;
        matrix = grid;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(matrix[i][j] == '1'){
                    count++;
                    bfs(i,j);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != '1') return;
        if( matrix[i][j] == '1')  matrix[i][j] = '0';
        bfs(i-1,j);
        bfs(i+1,j);
        bfs(i,j-1);
        bfs(i,j+1);
    }
}
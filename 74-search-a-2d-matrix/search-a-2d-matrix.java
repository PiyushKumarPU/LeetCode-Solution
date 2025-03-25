class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = n - 1;
        while (start < m && end >=0){
            if(matrix[start][end] == target) return true;
            else if (matrix[start][end] > target) end--;
            else start++;
        }
        return false; 
    }
}
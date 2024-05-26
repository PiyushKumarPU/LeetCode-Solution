class Solution {
    int[][] minMatrix;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty() || triangle.get(0).isEmpty()) return 0;
        int n = triangle.size(), m = triangle.get(n-1).size();
        minMatrix = new int[n][m];
        for(int[] arr : minMatrix) Arrays.fill(arr, -1);
        return calculateMinTotal(0,0, triangle);
    }

    private int calculateMinTotal(int i , int j, List<List<Integer>> triangle){
        if(!isValidIndex(i,j,triangle)) return 0;
        if(minMatrix[i][j] != -1) return minMatrix[i][j];
        minMatrix[i][j] = triangle.get(i).get(j) + 
            Math.min(calculateMinTotal(i +1 ,j,triangle), calculateMinTotal(i +1 ,j + 1,triangle));
        return minMatrix[i][j];
    }

    private boolean isValidIndex(int i, int j, List<List<Integer>> triangle){
        return (i >= 0 && i < triangle.size() && j >= 0 && j < triangle.get(i).size());
    }
}
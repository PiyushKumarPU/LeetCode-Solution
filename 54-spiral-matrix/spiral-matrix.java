class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = m * n;
        List<Integer> result = new ArrayList<>();

        if (m == 0 || n == 0) {
            return result;
        }

        int i = 0, j = 0;

        while (count > 0) {
            // Traverse from Left to Right
            for (int index = 0; index < n && count > 0; index++) {
                result.add(matrix[i][j++]);
                count--;
            }
            i++;
            j--;
            m--;

            // Traverse from Top to Bottom
            for (int index = 0; index < m && count > 0; index++) {
                result.add(matrix[i++][j]);
                count--;
            }
            i--;
            j--;
            n--;

            // Traverse from Right to Left
            for (int index = 0; index < n && count > 0; index++) {
                result.add(matrix[i][j--]);
                count--;
            }
            i--;
            j++;
            m--;

            // Traverse from Bottom to Top
            for (int index = 0; index < m && count > 0; index++) {
                result.add(matrix[i--][j]);
                count--;
            }
            i++;
            j++;
            n--;
        }
        return result;
    }
}
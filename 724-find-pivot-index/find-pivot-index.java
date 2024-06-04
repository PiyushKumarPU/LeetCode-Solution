class Solution {
    public int pivotIndex(int[] A) {
       if (A == null || A.length == 0) return 0;
        else if (A.length == 1) return 0;
        // calculate prefix sum array
        int[] pfSum = new int[A.length];
        pfSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pfSum[i] = A[i] + pfSum[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            int leftSum = i > 0 ? pfSum[i - 1] : 0;
            int rightSum = i == A.length - 1 ? 0 : pfSum[A.length - 1] - pfSum[i];
            if (leftSum == rightSum) return i;
        }
        return -1; 
    }
}
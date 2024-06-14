class Solution {
    public int firstMissingPositive(int[] A) {
        if(A.length == 1) return A[0] == 1 ? 2 : 1;
        // check for all the element greater than 0 and less than and equal to size and
        // keep it at appropriate index like 1 should be at index 0
        // A[i] should be at index A[i] - 1;
        for (int i = 0; i < A.length; i++) {
            while (A[i] >= 1 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                int temp = A[i];
                A[i] = A[A[i] - 1];
                A[temp - 1] = temp;
            }
        }
        // check first index where it does not have value i + 1
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }
}
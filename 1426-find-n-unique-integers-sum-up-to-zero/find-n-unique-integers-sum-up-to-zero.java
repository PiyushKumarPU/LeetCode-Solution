class Solution {
    public int[] sumZero(int n) {
        if(n <= 1) return new int[]{0};
        int[] result = new int[n];
        
        for (int i = 1; i <= n / 2; i++) {
            result[2 * (i - 1)] = i; 
            result[2 * (i - 1) + 1] = -i;
        }
        
        if (n % 2 != 0) {
            result[n - 1] = 0; 
        }
        
        return result;
        
    }
}
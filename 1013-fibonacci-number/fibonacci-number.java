class Solution {
    public int fib(int n) {
        if(n == 0  || n == 1) return n; 
        int first = 0, second = 1;
        for (int i = 1; i < n; i++) {
            int current = second + first;
            first = second;
            second = current;
        }
        return second;
    }
}
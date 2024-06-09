class Solution {
    public boolean isHappy(int n) {
        Set<Integer> processed = new HashSet<>();
        while (n != 1) {
            n = calculateDigitSquare(n);
            if (processed.contains(n)) return false;
            processed.add(n);
        }
        return true;
    }

    private int calculateDigitSquare(int n) {
        int result = 0;
        while (n > 0) {
            int digit = n % 10;
            result += (digit * digit);
            n /= 10;
        }
        return result;
    }
}
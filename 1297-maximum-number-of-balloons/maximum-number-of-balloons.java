class Solution {
    public int maxNumberOfBalloons(String text) {
       int[] counts = new int[5];
        for (char c : text.toCharArray()) {
            if (c == 'b') counts[0]++;
            else if (c == 'a') counts[1]++;
            else if (c == 'l') counts[2]++;
            else if (c == 'o') counts[3]++;
            else if (c == 'n') counts[4]++;
        }
        counts[2] /= 2;
        counts[3] /= 2;

        // Find the minimum count among all characters
        int min = counts[0];
        for (int i = 1; i < 5; i++) {
            min = Math.min(min, counts[i]);
        }

        return min;
    }
}
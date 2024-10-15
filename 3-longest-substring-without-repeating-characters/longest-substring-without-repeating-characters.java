class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
         int maxLength = 1, start = 0;
        int[] charIndex = new int[256];
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            start = Math.max(start, charIndex[c]);

            charIndex[c] = end + 1;

            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
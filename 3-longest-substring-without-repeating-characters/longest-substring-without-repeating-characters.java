class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
         int maxLength = 1, start = 0;
        int[] charIndex = new int[256];
        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // Update start position if the character was seen before
            start = Math.max(start, charIndex[c]);

            // Update the character's last seen index (+1 to avoid overlap)
            charIndex[c] = end + 1;

            // Calculate the maximum length so far
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty())
            return "";

        // Initialize pointers and variables
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        String minWindow = "";
        Map<Character, Integer> charCount = new HashMap<>();
        int requiredChars = 0, formedChars = 0;

        // Count characters in t
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            requiredChars++;
        }

        // Sliding window
        while (right < s.length()) {
            // Expand the window by moving the right pointer
            char ch = s.charAt(right);
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) - 1);
                if (charCount.get(ch) >= 0)
                    formedChars++;
            }

            // Contract the window by moving the left pointer
            while (formedChars == requiredChars && left <= right) {
                int tempLen = right - left + 1;
                if (tempLen < minLen) {
                    minLen = tempLen;
                    minWindow = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if (charCount.containsKey(leftChar)) {
                    charCount.put(leftChar, charCount.get(leftChar) + 1);
                    if (charCount.get(leftChar) > 0)
                        formedChars--;
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }
}
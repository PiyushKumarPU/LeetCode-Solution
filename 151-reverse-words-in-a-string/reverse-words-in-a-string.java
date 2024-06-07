class Solution {
    public String reverseWords(String s) {
        // Convert to char array for in-place modification
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        // Step 1: Trim leading and trailing spaces
        int start = 0, end = n - 1;
        while (start <= end && chars[start] == ' ') start++;
        while (start <= end && chars[end] == ' ') end--;
        
        // If the whole string is spaces, return empty string
        if (start > end) return "";

        // Step 2: Reverse the entire trimmed array
        reverse(chars, start, end);
        
        // Step 3: Reverse each word within the reversed array
        int wordStart = start;
        for (int i = start; i <= end; i++) {
            if (chars[i] == ' ') {
                reverse(chars, wordStart, i - 1);
                wordStart = i + 1;
            } else if (i == end) {
                reverse(chars, wordStart, i);
            }
        }
        
        // Step 4: Clean up spaces between words
        int i = start, j = start;
        while (i <= end) {
            if (chars[i] != ' ') {
                if (j > start && chars[j - 1] != ' ') chars[j++] = ' ';
                while (i <= end && chars[i] != ' ') chars[j++] = chars[i++];
            } else {
                i++;
            }
        }

        return new String(chars, start, j - start);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
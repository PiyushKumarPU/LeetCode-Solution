class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = computeLPSArray(needle + "#" + haystack);
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == needle.length()) return i - needle.length() * 2;
        }
        // If no match is found, return -1
        return -1;
    }

    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            int x = lps[i - 1];
            while (pattern.charAt(i) != pattern.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        int j = 0;
        int[] lps = computeLPSArray(needle);
        for (int i = 0; i < haystack.length(); ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] computeLPSArray(String pattern) {
        int length = pattern.length();
        int[] lps = new int[length];
        int lpsLength = 0;
        int i = 1;

        while (i < length) {
            if (pattern.charAt(i) == pattern.charAt(lpsLength)) {
                lpsLength++;
                lps[i] = lpsLength;
                i++;
            } else if (lpsLength != 0) {
                lpsLength = lps[lpsLength - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }    
}
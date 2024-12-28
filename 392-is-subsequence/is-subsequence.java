class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) return true;

        // start finding from char first and return once char is not present
        int start = 0, i = 0;
        for (i = 0; i < s.length(); i++) {
            while (start < t.length() && s.charAt(i) != t.charAt(start)) start++;
            if (start == t.length()) return false;
            start++;
        }
        // check if all character matched
        return i == s.length();
    }
}
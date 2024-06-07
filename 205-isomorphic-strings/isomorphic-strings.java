class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);
            if (m1[char1] != m2[char2]) return false;
            m1[char1] = i + 1;
            m2[char2] = i + 1;
        }
        return true;
    }
}
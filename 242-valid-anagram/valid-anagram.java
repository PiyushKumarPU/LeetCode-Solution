class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        else if((s == null || t == null) || (s.length() != t.length())) return false;
        int[] charCount = new int[26];
        for(int i = 0; i < s.length();i++){
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26;i++) 
            if(charCount[i] != 0) return false;

        return true;
    }
}
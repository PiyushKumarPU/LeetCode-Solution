class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length()== 0) return 0;
        int charCount = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == ' ' && charCount == 0) continue;
            else if(s.charAt(i) == ' ' && charCount > 0 ) return charCount;
            charCount++;
        }
        return charCount;
    }
}
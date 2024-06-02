class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.isEmpty()) return -1;
        //if(haystack.length() == needle.length() && haystack.equals(needle) ) return 0;
        int start = 0, nLen = needle.length();
        while (start <= haystack.length() - nLen) {
            if (haystack.substring(start, start + needle.length()).equals(needle)) return start;
            start++;
        }
        return -1;
    }    
}
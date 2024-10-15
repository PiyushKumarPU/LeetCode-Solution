class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;
        int maxLength = 1, start = 0, end = 0;
        Map<Character, Integer> valIndexMap = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (valIndexMap.containsKey(c)) {
                start = Math.max(start, valIndexMap.get(c) + 1);
            }
            valIndexMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
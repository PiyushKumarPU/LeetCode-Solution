class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) return 0;
        HashMap<Character, Integer> valueIndexMap = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;
        while (end < str.length()) {
            if (valueIndexMap.containsKey(str.charAt(end))) {
                start = Math.max(start, valueIndexMap.get(str.charAt(end)) + 1);
            }
            valueIndexMap.put(str.charAt(end), end);
            maxLength = Math.max(maxLength, (end - start + 1));
            end++;
        }
        return maxLength;
    }
}
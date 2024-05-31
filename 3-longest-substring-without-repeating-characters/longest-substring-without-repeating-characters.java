class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) return 0;
        HashMap<Character, Integer> valueIndexMap = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;
        //for (int end = 0; end < str.length(); end++) {
        while (end < str.length()){
            char currentChar = str.charAt(end);
            if (valueIndexMap.containsKey(currentChar)) {
                start = Math.max(start, valueIndexMap.get(currentChar) + 1);
            }
            valueIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
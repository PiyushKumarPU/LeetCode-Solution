class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null) return null;
        else if (strs.length == 1 && strs[0].isEmpty()) return "";
        StringBuilder minCommon = new StringBuilder("");
        // find min length String
        String minLengthStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLengthStr.length()) {
                minLengthStr = strs[i];
            }
        }
        // iterate through each character and check if it there at the same index for all the strings
        for (int i = 0; i < minLengthStr.length(); i++) {
            char c = minLengthStr.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return minCommon.toString();
                }
            }
            minCommon.append(c);
        }
        return minCommon.toString(); 
    }
}
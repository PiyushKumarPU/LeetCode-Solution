class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        else if (strs.length == 1) return strs[0];
        String minCommon = longestCommon(strs[0], strs[1]);
        if (minCommon.isEmpty()) return minCommon;
        for (int i = 2; i < strs.length; i++) {
            minCommon = longestCommon(minCommon, strs[i]);
            if (minCommon.isEmpty()) return minCommon;
        }
        return minCommon;
    }

    private String longestCommon(String str1, String str2){
        if(str1.length() > str2.length()) return longestCommon(str2,str1);
        StringBuilder str = new StringBuilder("");
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) == str2.charAt(i)) str.append(str1.charAt(i));
            else break;
        }
        return str.toString();
    }
}
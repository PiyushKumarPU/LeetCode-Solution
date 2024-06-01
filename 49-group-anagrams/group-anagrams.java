class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        for (int i = 0; i < strs.length; i++) {
            if (Objects.equals(strs[i], "-1")) continue;
            List<String> row = new ArrayList<>();
            row.add(strs[i]);
            int start = i + 1;
            while (start < strs.length) {
                if (strs[i].length() == strs[start].length() && strs[start] != "-1") {
                    if (isAnagram(strs[i], strs[start])) {
                        row.add(strs[start]);
                        strs[start] = "-1";
                    }
                }
                start++;
            }
            result.add(row);
        }
        return result;
    }

    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }
        for (int count : charCounts) if (count != 0) return false;
        return true;
    }
}
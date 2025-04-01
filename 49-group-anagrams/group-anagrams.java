class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return null;
        if (strs.length == 1) {
            List<String> row = new ArrayList<>();
            row.add(strs[0]);
            result.add(row);
            return result;
        }

        for (int i = 0; i < strs.length; i++) {
            String source = strs[i];
            strs[i] = "  ";
            if (Objects.equals(source, "  ")) continue;
            List<String> row = new ArrayList<>();
            row.add(source);
            for (int j = i + 1; j < strs.length; j++) {
                String target = strs[j];
                if (Objects.equals(target, "  ")) continue;
                if (isAnagram(source, target)) {
                    strs[j] = "  ";
                    row.add(target);
                }
            }
            result.add(row);
        }
        return result;
    }


    private boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.isEmpty() && str2.isEmpty()) return true;
        if (str1.length() != str2.length()) return false;

        int[] freq = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        TrieBucket root = new TrieBucket();

        // Find the minimum length of the strings in the array
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        if(minLength == 0) return "";
        // Build the Trie up to the length of the shortest string
        for (String str : strs) {
            TrieBucket temp = root;
            for (int i = 0; i < minLength; i++) {
                char current = str.charAt(i);
                if (!temp.cache.containsKey(current)) {
                    temp.cache.put(current, new TrieBucket());
                }
                temp = temp.cache.get(current);
            }
        }

        // Find the longest common prefix
        StringBuilder builder = new StringBuilder();
        TrieBucket temp = root;
        while (temp.cache.size() == 1) {
            Map.Entry<Character, TrieBucket> entry = temp.cache.entrySet().iterator().next();
            builder.append(entry.getKey());
            temp = entry.getValue();
        }
        return builder.toString();
    }
}

class TrieBucket {
    Map<Character, TrieBucket> cache;

    public TrieBucket() {
        cache = new HashMap<>();
    }
}
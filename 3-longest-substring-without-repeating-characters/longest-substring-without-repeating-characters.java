class Solution {
    public int lengthOfLongestSubstring(String s) {
      Set<Character> container = new HashSet<>();
        int start = 0, end = 0, max = 0;
        String result = "";
        while (end < s.length()) {
            if (!container.contains(s.charAt(end))) {
                container.add(s.charAt(end));
                int currentMax = end - start + 1;
                if (currentMax > max) {
                    max = currentMax;
                    result = s.substring(start, end + 1);
                }
                end++;
            } else {
                container.remove(s.charAt(start));
                start++;
            }
        }
        //System.out.println(result);
        return max;  
    }
}
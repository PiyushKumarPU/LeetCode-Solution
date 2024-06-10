class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
        for (int i : nums) elements.add(i);
        int maxLength = 0;
        for (int i : nums) {
            if (!elements.contains(i - 1)) {
                int currentCount = 1;
                while (elements.contains(i + currentCount)) currentCount++;
                maxLength = Math.max(maxLength, currentCount);
            }
        }
        return maxLength;
    }
}
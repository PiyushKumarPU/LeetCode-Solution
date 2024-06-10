class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
    for (int num : nums) {
        elements.add(num);
    }
    
    int maxLength = 0;
    
    for (int num : elements) {
        // Only check for the start of sequences
        if (!elements.contains(num - 1)) {
            int currentNum = num;
            int currentLength = 1;
            
            while (elements.contains(currentNum + 1)) {
                currentNum++;
                currentLength++;
            }
            
            maxLength = Math.max(maxLength, currentLength);
        }
    }
    
    return maxLength;
    }
}
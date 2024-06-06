class Solution {
    public int hIndex(int[] citations) {
        Integer[] sortedCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedCitations, Collections.reverseOrder());
        
        int hIndex = 0;
        // Iterate through the sorted array to find the h-index
        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        
        return hIndex;
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totalCount = 0, currentCount = 0;
        for (int num : nums) {
            if (num == 0) {
                currentCount++;
            } else {
                totalCount += (currentCount * (currentCount + 1)) / 2;
                currentCount = 0;
            }
        }
        totalCount += (currentCount * (currentCount + 1)) / 2;
        return totalCount;
    }
}
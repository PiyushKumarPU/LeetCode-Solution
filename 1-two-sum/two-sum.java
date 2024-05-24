class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int remaining = target - nums[i];
            int remainingIndex = valIndexMap.getOrDefault(remaining,-1);
            if(remainingIndex < 0) valIndexMap.put(nums[i],i);
            else return new int[]{remainingIndex,i};
        }
        return new int[]{-1,-1};
    }
}
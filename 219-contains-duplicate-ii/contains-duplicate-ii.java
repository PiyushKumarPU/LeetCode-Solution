class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> charCountMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int existingIndex = charCountMap.getOrDefault(nums[i], -1);
            if(existingIndex < 0) charCountMap.put(nums[i],i);
            else{
                int difference = Math.abs(i - existingIndex);
                if(difference <= k) return true;
                else charCountMap.put(nums[i],i);
            }
        }
        return false;
    }
}
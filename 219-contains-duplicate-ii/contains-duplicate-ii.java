class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (charCountMap.containsKey(curr) && i-charCountMap.get(curr) <=k) 
                return true;
            else 
                charCountMap.put(curr, i);
        }
        return false;
    }
}
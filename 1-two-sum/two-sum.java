class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (valueIndexMap.containsKey(current)) {
                return new int[]{valueIndexMap.get(current), i};
            }
            valueIndexMap.put(target - current, i);
        }
        return null;
    }
}
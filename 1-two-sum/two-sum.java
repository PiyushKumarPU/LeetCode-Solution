class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> valIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> existing = valIndexMap.getOrDefault(nums[i], new ArrayList<>());
            existing.add(i);
            valIndexMap.put(nums[i], existing);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            // pick on element and find remaining with different index
            int required = target - nums[i];
            if (valIndexMap.containsKey(required)) {
                List<Integer> list = valIndexMap.get(required);
                for (int index : list) {
                    if (index != i) return new int[]{i, index};
                }
            }
        }
        return null;
    }
}
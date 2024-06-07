class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> result = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        
        while (i < n) {
            int start = i;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (i == start) {
                result.add(Integer.toString(nums[start]));
            } else {
                result.add(nums[start] + "->" + nums[i]);
            }
            i++;
        }
        
        return result;
    }
}